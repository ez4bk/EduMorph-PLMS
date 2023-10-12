package ca.umd.lms.faculty.mapper;

import ca.umd.lms.faculty.dto.FacultyDTO;
import ca.umd.lms.faculty.model.Faculty;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper extends BaseMapper<Faculty, FacultyDTO, Long> {}
