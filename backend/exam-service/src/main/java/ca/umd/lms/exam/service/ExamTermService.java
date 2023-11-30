package ca.umd.lms.exam.service;

import ca.umd.lms.exam.dto.ExamTermDTO;
import ca.umd.lms.exam.dto.SubjectDTO;
import ca.umd.lms.exam.dto.SubjectEnrollmentDTO;
import ca.umd.lms.exam.client.SubjectFeignClient;
import ca.umd.lms.exam.mapper.ExamTermMapper;
import ca.umd.lms.exam.model.ExamRealization;
import ca.umd.lms.exam.model.ExamTerm;
import ca.umd.lms.exam.repository.ExamRealizationRepository;
import ca.umd.lms.exam.repository.ExamTermRepository;
import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class ExamTermService extends ExtendedService<ExamTerm, ExamTermDTO, Long> {
    private final ExamTermRepository repository;
    private final ExamTermMapper mapper;
    private final ExamRealizationRepository examRealizationRepository;
    private final SubjectFeignClient subjectFeignClient;

    public ExamTermService(
            ExamTermRepository repository,
            ExamTermMapper mapper,
            ExamRealizationRepository examRealizationRepository,
            SubjectFeignClient subjectFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.examRealizationRepository = examRealizationRepository;
        this.subjectFeignClient = subjectFeignClient;
    }

    @Override
    //overrides the mapMissingValues method from the superclass (ExtendedService). It's responsible for mapping missing values in a list of ExamTermDTO objects. 
    //Specifically, it uses a Feign client (subjectFeignClient) to fetch missing details related to subjects for each exam term.
    // The map method seems to be a utility method for performing this mapping operation.
    protected List<ExamTermDTO> mapMissingValues(List<ExamTermDTO> examTerms) {
        map(
                examTerms,
                examTerm -> examTerm.getExam().getSubject(),
                (examTerm, subject) -> examTerm.getExam().setSubject(subject),
                subjectFeignClient::getSubject);

        return examTerms;
    }
// retrieves a list of ExamTermDTO objects based on the provided subject ID. It uses the mapper to convert ExamTerm entities to ExamTermDTO objects and then calls the mapMissingValues method to fill in missing subject details.
    public List<ExamTermDTO> findBySubjectId(Long id) {
        List<ExamTermDTO> examTerms =
                mapper.toDTO(repository.findByExamSubjectIdAndDeletedFalseOrderByStartTimeDesc(id));
        return examTerms.isEmpty() ? examTerms : this.mapMissingValues(examTerms);
    }


//retrieves a list of ExamTermDTO objects based on the provided teacher ID. It uses a Feign client to get subject IDs associated with the teacher and then retrieves exam terms for those subjects. Similar to findBySubjectId, it also calls mapMissingValues to fill in missing subject details.
    public List<ExamTermDTO> findByTeacherId(Long id) {
        List<Long> subjectIds =
                subjectFeignClient.getSubjectByTeacherId(id).stream()
                        .map(SubjectDTO::getId)
                        .toList();

        List<ExamTermDTO> examTerms =
                mapper.toDTO(
                        repository.findByExamSubjectIdInAndDeletedFalseOrderByStartTimeDesc(
                                subjectIds));
        return examTerms.isEmpty() ? examTerms : this.mapMissingValues(examTerms);
    }
//retrieves a paginated list of ExamTermDTO objects based on the provided student ID and search criteria. 
//It involves complex logic to filter and fetch exam terms based on subject enrollments, exam realizations, and registered exam terms. Similar to the previous methods, it also calls mapMissingValues to fill in missing subject details.
    public Page<ExamTermDTO> findByStudentId(Long id, Pageable pageable, String search) {
        if (hasAuthority(ROLE_STUDENT) && !id.equals(getStudentId())) {
            throw new ForbiddenException("You are not allowed to view these exam terms");
        }

        List<Long> subjectIds =
                subjectFeignClient.getSubjectByStudentId(id).stream()
                        .map(SubjectDTO::getId)
                        .toList();

        List<Long> subjectEnrollmentIds =
                subjectFeignClient.getSubjectEnrollmentByStudentId(id).stream()
                        .map(SubjectEnrollmentDTO::getId)
                        .toList();

        List<Long> examRealizationIds =
                examRealizationRepository
                        .findBySubjectEnrollmentIdInAndDeletedFalse(subjectEnrollmentIds)
                        .stream()
                        .map(ExamRealization::getId)
                        .toList();

        List<Long> registeredExamTermIds =
                repository
                        .findByExamSubjectIdInAndExamRealizationsIdInAndDeletedFalse(
                                subjectIds, examRealizationIds)
                        .stream()
                        .map(ExamTerm::getId)
                        .toList();

        Page<ExamTermDTO> examTerms =
                repository
                        .findRegistrableContaining(
                                subjectIds,
                                registeredExamTermIds,
                                LocalDate.now(),
                                pageable,
                                "%" + search + "%")
                        .map(mapper::toDTO);

        return examTerms.isEmpty()
                ? examTerms
                : new PageImpl<>(
                        this.mapMissingValues(examTerms.getContent()),
                        pageable,
                        examTerms.getTotalElements());
    }
}
