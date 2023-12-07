package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.StudentGradeDTO;
import com.rocket.edumorphplms.entity.StudentGrade;
import com.rocket.edumorphplms.repository.StudentGradeRepository;
import com.rocket.edumorphplms.service.StudentGradeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentGradeServiceTest {

    @Autowired
    private StudentGradeService studentGradeService;

    @Autowired
    private StudentGradeRepository studentGradeRepository;

    @Test
    public void testGetStudentGradeById() {
        Long gradeId = 1L;

        Optional<StudentGrade> studentGradeOptional = studentGradeRepository.findById(gradeId);

        assertTrue(studentGradeOptional.isPresent());

        StudentGrade studentGrade = studentGradeOptional.get();

        StudentGradeDTO studentGradeDTO = studentGradeService.getStudentGradeById(gradeId);

        assertEquals(studentGrade.getGradeId(), studentGradeDTO.getGradeId());
        assertEquals(studentGrade.getEnrollment().getEnrollmentId(), studentGradeDTO.getEnrollmentId());
        assertEquals(studentGrade.getAssignment().getAssignmentId(), studentGradeDTO.getAssignmentId());
        assertEquals(studentGrade.getGrade(), studentGradeDTO.getGrade());
    }

    @Test
    public void testGetStudentGradesByEnrollmentId() {
        Long enrollmentId = 1L;

        List<StudentGrade> studentGradeList = studentGradeRepository.findByEnrollmentEnrollmentId(enrollmentId);

        // Convert StudentGrade entities to StudentGradeDTOs
        List<StudentGradeDTO> studentGradeDTOList = studentGradeList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        assertEquals(studentGradeList.size(), studentGradeDTOList.size());

        for (int i = 0; i < studentGradeList.size(); i++) {
            assertEquals(studentGradeList.get(i).getGradeId(), studentGradeDTOList.get(i).getGradeId());
            assertEquals(studentGradeList.get(i).getEnrollment().getEnrollmentId(), studentGradeDTOList.get(i).getEnrollmentId());
            assertEquals(studentGradeList.get(i).getAssignment().getAssignmentId(), studentGradeDTOList.get(i).getAssignmentId());
            assertEquals(studentGradeList.get(i).getGrade(), studentGradeDTOList.get(i).getGrade());
        }
    }

    private StudentGradeDTO convertToDTO(StudentGrade studentGrade) {
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
        studentGradeDTO.setGradeId(studentGrade.getGradeId());
        studentGradeDTO.setEnrollmentId(studentGrade.getEnrollment().getEnrollmentId());
        studentGradeDTO.setAssignmentId(studentGrade.getAssignment().getAssignmentId());
        studentGradeDTO.setGrade(studentGrade.getGrade());
        return studentGradeDTO;
    }
}
// ```