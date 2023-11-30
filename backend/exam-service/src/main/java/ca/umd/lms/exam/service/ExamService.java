package ca.umd.lms.exam.service;

import ca.umd.lms.exam.client.SubjectFeignClient;
import ca.umd.lms.exam.dto.ExamDTO;
import ca.umd.lms.exam.dto.SubjectDTO;
import ca.umd.lms.exam.mapper.ExamMapper;
import ca.umd.lms.exam.model.Exam;
import ca.umd.lms.exam.repository.ExamRepository;
import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class ExamService extends ExtendedService<Exam, ExamDTO, Long> {
    private final ExamRepository repository;
    private final ExamMapper mapper;
    private final SubjectFeignClient subjectFeignClient;

    public ExamService(
            ExamRepository repository, ExamMapper mapper, SubjectFeignClient subjectFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.subjectFeignClient = subjectFeignClient;
    }

    @Override
    @Transactional
    //is responsible for saving an ExamDTO object. Before saving, it checks if the current user has the authority of a teacher (ROLE_TEACHER). If the user is a teacher, 
    //it further checks if they are allowed to add materials to the subject specified in the examDTO. If not, it throws a ForbiddenException. 
    //If the checks pass, it delegates the saving operation to the superclass (ExtendedService) and returns the result.
    public ExamDTO save(ExamDTO examDTO) {
        if (hasAuthority(ROLE_TEACHER)) {
            Long teacherId = getTeacherId();
            SubjectDTO subject = examDTO.getSubject();
            if (!subject.getProfessor().getId().equals(teacherId)
                    && !subject.getAssistant().getId().equals(teacherId)) {
                throw new ForbiddenException(
                        "You are not allowed to add materials to this subject");
            }
        }

        return super.save(examDTO);
    }

    @Override
    @Transactional
    // overrides the delete method from the superclass. It is responsible for deleting exams by their IDs. Similar to the save method, it checks if the current user has the authority of a teacher. 
    //If the user is a teacher, it checks if they are allowed to delete the specified exams based on the associated subjects. If not, it throws a ForbiddenException. If the checks pass, 
    //it delegates the deletion operation to the superclass.
    public void delete(Set<Long> id) {
        if (hasAuthority(ROLE_TEACHER)) {
            Long teacherId = getTeacherId();
            List<Exam> exams = (List<Exam>) repository.findAllById(id);
            List<SubjectDTO> subjects =
                    subjectFeignClient.getSubject(
                            exams.stream().map(Exam::getSubjectId).collect(Collectors.toSet()));

            boolean forbidden =
                    subjects.stream()
                            .anyMatch(
                                    subject ->
                                            !subject.getProfessor().getId().equals(teacherId)
                                                    && !subject.getAssistant()
                                                            .getId()
                                                            .equals(teacherId));
            if (forbidden) {
                throw new ForbiddenException("You are not allowed to delete these exams");
            }
        }

        super.delete(id);
    }

    @Override
    //It is responsible for mapping missing values in a list of ExamDTO objects. Specifically, it uses a subjectFeignClient to fetch missing details related to subjects.
    protected List<ExamDTO> mapMissingValues(List<ExamDTO> exams) {
        map(exams, ExamDTO::getSubject, ExamDTO::setSubject, subjectFeignClient::getSubject);
        return exams;
    }


//retrieves a list of ExamDTO objects based on the provided subject ID. It uses the mapper to convert Exam entities to ExamDTO objects and then calls the mapMissingValues method to fill in missing subject details.
    public List<ExamDTO> findBySubjectId(Long id) {
        List<ExamDTO> exams = mapper.toDTO(repository.findBySubjectIdAndDeletedFalse(id));
        return exams.isEmpty() ? exams : this.mapMissingValues(exams);
    }



//ExamDTO objects based on the provided subject ID and search criteria. It uses the repository to fetch data, applies the mapper for conversion, 
//and then calls the mapMissingValues method for filling in missing subject details. If the content is not empty, it creates a new PageImpl instance
    public Page<ExamDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        Page<ExamDTO> exams =
                repository
                        .findBySubjectIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return exams.getContent().isEmpty()
                ? exams
                : new PageImpl<>(
                        this.mapMissingValues(exams.getContent()),
                        pageable,
                        exams.getTotalElements());
    }
}
