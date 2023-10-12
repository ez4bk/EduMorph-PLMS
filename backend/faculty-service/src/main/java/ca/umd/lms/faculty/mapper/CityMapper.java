package ca.umd.lms.faculty.mapper;

import ca.umd.lms.faculty.dto.CityDTO;
import ca.umd.lms.faculty.model.City;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends BaseMapper<City, CityDTO, Long> {}
