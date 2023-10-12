package ca.umd.lms.subject.mapper;

import ca.utoronto.lms.shared.mapper.BaseMapper;
import ca.umd.lms.subject.dto.SubjectDTO;
import ca.umd.lms.subject.dto.SubjectMaterialDTO;
import ca.umd.lms.subject.dto.TeacherDTO;
import ca.umd.lms.subject.model.Subject;
import ca.umd.lms.subject.model.SubjectMaterial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMaterialMapper
        extends BaseMapper<SubjectMaterial, SubjectMaterialDTO, Long> {
    @Mapping(source = "teacherId", target = "teacher")
    SubjectMaterialDTO toDTO(SubjectMaterial subjectMaterial);

    @Mapping(source = "teacher.id", target = "teacherId")
    SubjectMaterial toModel(SubjectMaterialDTO subjectMaterialDTO);

    TeacherDTO teacherDTOFromId(Long id);

    @Mapping(target = "studyProgram", ignore = true)
    @Mapping(target = "professor", ignore = true)
    @Mapping(target = "assistant", ignore = true)
    SubjectDTO toDTO(Subject subject);
}
