package ca.umd.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.umd.lms.subject.dto.SubjectDTO;
import ca.umd.lms.subject.dto.SubjectNotificationDTO;
import ca.umd.lms.subject.dto.TeacherDTO;
import ca.umd.lms.subject.model.Subject;
import ca.umd.lms.subject.model.SubjectNotification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectNotificationMapper
        extends BaseMapper<SubjectNotification, SubjectNotificationDTO, Long> {
    @Mapping(source = "teacherId", target = "teacher")
    SubjectNotificationDTO toDTO(SubjectNotification subjectNotification);

    @Mapping(source = "teacher.id", target = "teacherId")
    SubjectNotification toModel(SubjectNotificationDTO subjectNotificationDTO);

    TeacherDTO teacherDTOFromId(Long id);

    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);
}
