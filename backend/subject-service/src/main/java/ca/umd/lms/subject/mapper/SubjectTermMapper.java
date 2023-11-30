package ca.umd.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.umd.lms.subject.dto.SubjectDTO;
import ca.umd.lms.subject.dto.SubjectTermDTO;
import ca.umd.lms.subject.dto.TeacherDTO;
import ca.umd.lms.subject.model.Subject;
import ca.umd.lms.subject.model.SubjectTerm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectTermMapper extends BaseMapper<SubjectTerm, SubjectTermDTO, Long> {
    @Mapping(source = "teacherId", target = "teacher")
    SubjectTermDTO toDTO(SubjectTerm SubjectTerm);

    @Mapping(source = "teacher.id", target = "teacherId")
    SubjectTerm toModel(SubjectTermDTO SubjectTermDTO);

    TeacherDTO teacherDTOFromId(Long id);

    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);
}
