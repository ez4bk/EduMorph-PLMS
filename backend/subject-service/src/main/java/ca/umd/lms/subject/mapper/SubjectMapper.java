package ca.umd.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.umd.lms.subject.dto.StudyProgramDTO;
import ca.umd.lms.subject.dto.SubjectDTO;
import ca.umd.lms.subject.dto.TeacherDTO;
import ca.umd.lms.subject.model.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends BaseMapper<Subject, SubjectDTO, Long> {
    @Mapping(source = "studyProgramId", target = "studyProgram")
    @Mapping(source = "professorId", target = "professor")
    @Mapping(source = "assistantId", target = "assistant")
    SubjectDTO toDTO(Subject subject);

    @Mapping(source = "studyProgram.id", target = "studyProgramId")
    @Mapping(source = "professor.id", target = "professorId")
    @Mapping(source = "assistant.id", target = "assistantId")
    Subject toModel(SubjectDTO subjectDTO);

    StudyProgramDTO studyProgramDTOFromId(Long id);

    TeacherDTO teacherFromId(Long id);
}
