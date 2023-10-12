package ca.umd.lms.faculty.mapper;

import ca.umd.lms.faculty.dto.AddressDTO;
import ca.umd.lms.faculty.model.Address;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO, Long> {}
