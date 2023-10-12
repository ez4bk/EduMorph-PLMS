package ca.umd.lms.faculty.service;

import ca.umd.lms.faculty.dto.CityDTO;
import ca.umd.lms.faculty.mapper.CityMapper;
import ca.umd.lms.faculty.model.City;
import ca.umd.lms.faculty.repository.CityRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CityService extends BaseService<City, CityDTO, Long> {
    private final CityRepository repository;
    private final CityMapper mapper;

    public CityService(CityRepository repository, CityMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
