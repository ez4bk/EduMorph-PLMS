package ca.umd.lms.faculty.mapper;

import ca.umd.lms.faculty.dto.FacultyDTO;
import ca.umd.lms.faculty.dto.StudyProgramDTO;
import ca.umd.lms.faculty.model.Faculty;
import ca.umd.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudyProgramMapper extends BaseMapper<StudyProgram, StudyProgramDTO, Long> {
    @Mapping(target = "dean", ignore = true)
    @Mapping(target = "address", ignore = true)
    FacultyDTO toDTO(Faculty faculty);
}
