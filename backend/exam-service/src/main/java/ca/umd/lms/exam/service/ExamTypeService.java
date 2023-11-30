package ca.umd.lms.exam.service;

import ca.umd.lms.exam.dto.ExamTypeDTO;
import ca.umd.lms.exam.mapper.ExamTypeMapper;
import ca.umd.lms.exam.model.ExamType;
import ca.umd.lms.exam.repository.ExamTypeRepository;
import ca.utoronto.lms.shared.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ExamTypeService extends BaseService<ExamType, ExamTypeDTO, Long> {
    private final ExamTypeRepository repository;
    private final ExamTypeMapper mapper;

    public ExamTypeService(ExamTypeRepository repository, ExamTypeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
