package ca.umd.lms.faculty.mapper;

import ca.umd.lms.faculty.dto.StudentDTO;
import ca.umd.lms.faculty.dto.ThesisDTO;
import ca.umd.lms.faculty.model.Student;
import ca.umd.lms.faculty.model.Thesis;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThesisMapper extends BaseMapper<Thesis, ThesisDTO, Long> {
    @Mapping(target = "thesis", ignore = true)
    @Mapping(target = "studyProgram", ignore = true)
    StudentDTO toDTO(Student student);
}
