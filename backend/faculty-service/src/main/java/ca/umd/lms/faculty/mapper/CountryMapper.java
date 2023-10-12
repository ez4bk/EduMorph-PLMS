package ca.umd.lms.faculty.mapper;

import ca.umd.lms.faculty.dto.CountryDTO;
import ca.umd.lms.faculty.model.Country;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper extends BaseMapper<Country, CountryDTO, Long> {}
