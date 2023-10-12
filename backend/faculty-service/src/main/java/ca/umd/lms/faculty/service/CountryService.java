package ca.umd.lms.faculty.service;

import ca.umd.lms.faculty.dto.CountryDTO;
import ca.umd.lms.faculty.mapper.CountryMapper;
import ca.umd.lms.faculty.model.Country;
import ca.umd.lms.faculty.repository.CountryRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends BaseService<Country, CountryDTO, Long> {
    private final CountryRepository repository;
    private final CountryMapper mapper;

    public CountryService(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
