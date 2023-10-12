package ca.umd.lms.faculty.service;

import ca.umd.lms.faculty.dto.AddressDTO;
import ca.umd.lms.faculty.mapper.AddressMapper;
import ca.umd.lms.faculty.model.Address;
import ca.umd.lms.faculty.repository.AddressRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, AddressDTO, Long> {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
