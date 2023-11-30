package ca.umd.lms.subject.service;

import ca.utoronto.lms.shared.exception.ForbiddenException;
import ca.utoronto.lms.shared.exception.NotFoundException;
import ca.utoronto.lms.shared.service.ExtendedService;
import ca.umd.lms.subject.client.FacultyFeignClient;
import ca.umd.lms.subject.dto.SubjectDTO;
import ca.umd.lms.subject.mapper.SubjectMapper;
import ca.umd.lms.subject.model.Subject;
import ca.umd.lms.subject.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static ca.utoronto.lms.shared.security.SecurityUtils.*;

@Service
public class SubjectService extends ExtendedService<Subject, SubjectDTO, Long> {
    private final SubjectRepository repository;
    private final SubjectMapper mapper;
    private final FacultyFeignClient facultyFeignClient;

    public SubjectService(
            SubjectRepository repository,
            SubjectMapper mapper,
            FacultyFeignClient facultyFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.facultyFeignClient = facultyFeignClient;
    }

    protected List<SubjectDTO> mapMissingValues(List<SubjectDTO> subjects) {
        map(
                subjects,
                SubjectDTO::getStudyProgram,
                SubjectDTO::setStudyProgram,
                facultyFeignClient::getStudyProgram);
        map(
                subjects,
                SubjectDTO::getProfessor,
                SubjectDTO::setProfessor,
                facultyFeignClient::getTeacher);
        map(
                subjects,
                SubjectDTO::getAssistant,
                SubjectDTO::setAssistant,
                facultyFeignClient::getTeacher);

        return subjects;
    }
    //Retrieves a list of subjects based on the given study program ID.
//Orders the subjects by semester, then by name.
//Maps missing values in the retrieved subjects.

    public List<SubjectDTO> findByStudyProgramId(Long id) {
        List<SubjectDTO> subjects =
                mapper.toDTO(
                        repository.findByStudyProgramIdAndDeletedFalseOrderBySemesterAscNameAsc(
                                id));
        return subjects.isEmpty() ? subjects : this.mapMissingValues(subjects);
    }

//Retrieves a list of subjects based on the given teacher ID.
//Orders the subjects by semester, then by name.
//Maps missing values in the retrieved subjects.
    public List<SubjectDTO> findByTeacherId(Long id) {
        List<SubjectDTO> subjects =
                mapper.toDTO(
                        repository
                                .findByProfessorIdOrAssistantIdAndDeletedFalseOrderBySemesterAscNameAsc(
                                        id, id));
        return subjects.isEmpty() ? subjects : this.mapMissingValues(subjects);
    }
//Retrieves a list of subjects based on the given student ID.
//Checks for authorization to view the student's subjects.
//Maps missing values in the retrieved subjects.
    public List<SubjectDTO> findByStudentId(Long id) {
        if (hasAuthority(ROLE_STUDENT) && !id.equals(getStudentId())) {
            throw new ForbiddenException("You are not allowed to view this student");
        }

        List<SubjectDTO> subjects =
                mapper.toDTO(repository.findBySubjectEnrollmentsStudentIdAndDeletedFalse(id));
        return subjects.isEmpty() ? subjects : this.mapMissingValues(subjects);
    }

    @Transactional
    //Updates the syllabus of a subject identified by the given ID.
//Checks if the user has the ROLE_TEACHER authority.
//Verifies that the teacher attempting to update the syllabus is associated with the subject.
//Performs the update within a transactional context.
    public SubjectDTO updateSyllabus(Long id, String syllabus) {
        Subject subject =
                repository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Subject not found"));

        if (hasAuthority(ROLE_TEACHER)
                && !subject.getProfessorId().equals(getTeacherId())
                && !subject.getAssistantId().equals(getTeacherId())) {
            throw new ForbiddenException("You are not allowed to update this subject syllabus");
        }

        subject.setSyllabus(syllabus);
        return mapper.toDTO(repository.save(subject));
    }
}
