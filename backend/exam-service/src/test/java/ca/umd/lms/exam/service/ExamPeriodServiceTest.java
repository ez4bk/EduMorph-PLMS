package ca.umd.lms.exam.service;

import ca.umd.lms.exam.dto.ExamPeriodDTO;
import ca.umd.lms.exam.dto.FacultyDTO;
import ca.umd.lms.exam.client.FacultyFeignClient;
import ca.umd.lms.exam.mapper.ExamPeriodMapper;
import ca.umd.lms.exam.repository.ExamPeriodRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamPeriodServiceTest {

    @Mock
    private ExamPeriodRepository repository;

    @Mock
    private ExamPeriodMapper mapper;

    @Mock
    private FacultyFeignClient facultyFeignClient;

    @InjectMocks
    private ExamPeriodService service;

    @Test
    void testMapMissingValues() {
        // Given
        List<ExamPeriodDTO> examPeriods = new ArrayList<>();
        ExamPeriodDTO examPeriodDTO = new ExamPeriodDTO();
        examPeriodDTO.setId(1L);
        examPeriods.add(examPeriodDTO);

        Set<Long> facultyIds = new HashSet<>();
        facultyIds.add(1L);

        List<FacultyDTO> facultyList = new ArrayList<>();
        FacultyDTO facultyDto = new FacultyDTO(); 
        facultyList.add(facultyDto);

        // When
        when(facultyFeignClient.getFaculty(facultyIds)).thenReturn(facultyList);
        service.mapMissingValues(examPeriods);

    }
}
