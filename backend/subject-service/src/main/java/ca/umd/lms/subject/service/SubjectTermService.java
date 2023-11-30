package ca.umd.lms.subject.service;

import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.ExtendedService;
import ca.umd.lms.subject.client.FacultyFeignClient;
import ca.umd.lms.subject.dto.SubjectDTO;
import ca.umd.lms.subject.dto.SubjectTermDTO;
import ca.umd.lms.subject.dto.TeacherDTO;
import ca.umd.lms.subject.mapper.SubjectTermMapper;
import ca.umd.lms.subject.model.Subject;
import ca.umd.lms.subject.model.SubjectTerm;
import ca.umd.lms.subject.repository.SubjectTermRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class SubjectTermService extends ExtendedService<SubjectTerm, SubjectTermDTO, Long> {
    private final SubjectTermRepository repository;
    private final SubjectTermMapper mapper;
    private final SubjectTermRepository subjectRepository;
    private final FacultyFeignClient facultyFeignClient;

    public SubjectTermService(
            SubjectTermRepository repository,
            SubjectTermMapper mapper,
            SubjectTermRepository subjectRepository,
            FacultyFeignClient facultyFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.subjectRepository = subjectRepository;
        this.facultyFeignClient = facultyFeignClient;
    }

    @Override
    @Transactional
    //Allows the addition of subject terms.
//Checks if the user has the ROLE_TEACHER authority.
//Ensures that the teacher attempting to add terms is associated with the subject.
//If the teacher is not explicitly set in the subjectTermDTO, it sets it to the teacher making the request.
//Uses the super.save method to save the subject term.
    public SubjectTermDTO save(SubjectTermDTO subjectTermDTO) {
        if (hasAuthority(ROLE_TEACHER)) {
            TeacherDTO teacher = facultyFeignClient.getTeacher(Set.of(getTeacherId())).get(0);
            SubjectDTO subject = subjectTermDTO.getSubject();
            if (!subject.getProfessor().getId().equals(teacher.getId())
                    && !subject.getAssistant().getId().equals(teacher.getId())) {
                throw new ForbiddenException("You are not allowed to add terms to this subject");
            }

            if (subjectTermDTO.getTeacher() == null) {
                subjectTermDTO.setTeacher(teacher);
            }
        }

        return super.save(subjectTermDTO);
    }

    @Override
    @Transactional
    //Allows the deletion of subject terms identified by the given IDs.
//Checks if the user has the ROLE_TEACHER authority.
//Verifies that the teacher attempting to delete terms is associated with the subject.
//Uses the super.delete method to perform the deletion within a transactional context.
    public void delete(Set<Long> id) {
        if (hasAuthority(ROLE_TEACHER)) {
            Long teacherId = getTeacherId();
            List<SubjectTerm> subjectTerms = (List<SubjectTerm>) repository.findAllById(id);
            boolean forbidden =
                    subjectTerms.stream()
                            .anyMatch(
                                    subjectTerm -> {
                                        Subject subject = subjectTerm.getSubject();
                                        return !subject.getProfessorId().equals(teacherId)
                                                && !subject.getAssistantId().equals(teacherId);
                                    });
            if (forbidden) {
                throw new ForbiddenException("You are not allowed to delete these subject terms");
            }
        }

        super.delete(id);
    }

    @Override
    //Maps missing values, specifically the teacher, in the list of subject term DTOs.
//Utilizes the facultyFeignClient to retrieve teacher information based on teacher IDs.
    protected List<SubjectTermDTO> mapMissingValues(List<SubjectTermDTO> subjectTerms) {
        map(
                subjectTerms,
                SubjectTermDTO::getTeacher,
                SubjectTermDTO::setTeacher,
                facultyFeignClient::getTeacher);

        return subjectTerms;
    }
//Retrieves a list of subject terms based on the given subject ID.
//Orders the subject terms by start time in descending order.
//Checks if the subject exists; otherwise, throws a NotFoundException.
    public List<SubjectTermDTO> findBySubjectId(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new NotFoundException("Subject not found");
        }

        List<SubjectTermDTO> subjectTerms =
                mapper.toDTO(repository.findBySubjectIdAndDeletedFalseOrderByStartTimeDesc(id));
        return subjectTerms.isEmpty() ? subjectTerms : this.mapMissingValues(subjectTerms);
    }
//Retrieves a page of subject terms based on the given subject ID, pageable information, and search criteria.
//Uses the repository to perform the query.
//Maps missing values in the retrieved subject terms.
    public Page<SubjectTermDTO> findBySubjectId(Long id, Pageable pageable, String search) {
        if (!subjectRepository.existsById(id)) {
            throw new NotFoundException("Subject not found");
        }

        Page<SubjectTermDTO> subjectTerms =
                repository
                        .findBySubjectIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return subjectTerms.getContent().isEmpty()
                ? subjectTerms
                : new PageImpl<>(
                        this.mapMissingValues(subjectTerms.getContent()),
                        pageable,
                        subjectTerms.getTotalElements());
    }
}
