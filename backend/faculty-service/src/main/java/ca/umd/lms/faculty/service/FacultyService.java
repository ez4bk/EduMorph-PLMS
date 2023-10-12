package ca.umd.lms.faculty.service;

import ca.umd.lms.faculty.dto.FacultyDTO;
import ca.umd.lms.faculty.mapper.FacultyMapper;
import ca.umd.lms.faculty.model.Faculty;
import ca.umd.lms.faculty.repository.FacultyRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class FacultyService extends BaseService<Faculty, FacultyDTO, Long> {
    private final FacultyRepository repository;
    private final FacultyMapper mapper;

    public FacultyService(FacultyRepository repository, FacultyMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
