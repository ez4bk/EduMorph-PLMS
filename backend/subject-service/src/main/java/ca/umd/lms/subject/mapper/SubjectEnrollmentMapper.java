package ca.umd.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.umd.lms.subject.dto.StudentDTO;
import ca.umd.lms.subject.dto.SubjectDTO;
import ca.umd.lms.subject.dto.SubjectEnrollmentDTO;
import ca.umd.lms.subject.dto.TeacherDTO;
import ca.umd.lms.subject.model.Subject;
import ca.umd.lms.subject.model.SubjectEnrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectEnrollmentMapper
        extends BaseMapper<SubjectEnrollment, SubjectEnrollmentDTO, Long> {
    @Mapping(source = "studentId", target = "student")
    SubjectEnrollmentDTO toDTO(SubjectEnrollment subjectEnrollment);

    @Mapping(source = "student.id", target = "studentId")
    SubjectEnrollment toModel(SubjectEnrollmentDTO subjectEnrollmentDTO);

    StudentDTO studentDTOFromId(Long id);

    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(source = "professorId", target = "professor")
    @Mapping(source = "assistantId", target = "assistant")
    SubjectDTO toDTO(Subject subject);

    TeacherDTO teacherDTOFromId(Long id);
}
