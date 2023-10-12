package ca.umd.lms.exam.mapper;

import ca.umd.lms.exam.dto.ExamDTO;
import ca.umd.lms.exam.dto.ExamPeriodDTO;
import ca.umd.lms.exam.dto.ExamTermDTO;
import ca.umd.lms.exam.dto.SubjectDTO;
import ca.umd.lms.exam.model.Exam;
import ca.umd.lms.exam.model.ExamPeriod;
import ca.umd.lms.exam.model.ExamTerm;
import ca.utoronto.lms.shared.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamTermMapper extends BaseMapper<ExamTerm, ExamTermDTO, Long> {
    @Mapping(source = "subjectId", target = "subject")
    @Mapping(target = "examType", ignore = true)
    ExamDTO toDTO(Exam exam);

    @Mapping(source = "subject.id", target = "subjectId")
    Exam toModel(ExamDTO examDTO);

    SubjectDTO subjectDTOFromId(Long id);

    @Mapping(target = "faculty", ignore = true)
    ExamPeriodDTO toDTO(ExamPeriod examPeriod);
}
