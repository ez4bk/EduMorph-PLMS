package ca.umd.lms.exam.mapper;

import ca.umd.lms.exam.dto.ExamTypeDTO;
import ca.umd.lms.exam.model.ExamType;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamTypeMapper extends BaseMapper<ExamType, ExamTypeDTO, Long> {}
