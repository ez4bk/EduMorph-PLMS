package ca.umd.lms.exam.mapper;

import ca.umd.lms.exam.dto.ExamDTO;
import ca.umd.lms.exam.dto.SubjectDTO;
import ca.umd.lms.exam.model.Exam;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamMapper extends BaseMapper<Exam, ExamDTO, Long> {
    @Mapping(source = "subjectId", target = "subject")
    ExamDTO toDTO(Exam exam);

    @Mapping(source = "subject.id", target = "subjectId")
    Exam toModel(ExamDTO examDTO);

    SubjectDTO subjectDTOFromId(Long id);
}
