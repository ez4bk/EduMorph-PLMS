package com.rocket.edumorphplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.edumorphplms.dto.StudentGradeDTO;
import com.rocket.edumorphplms.entity.StudentGrade;
import com.rocket.edumorphplms.exception.StudentGradeNotFoundException; // Import the custom exception
import com.rocket.edumorphplms.repository.StudentGradeRepository;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class StudentGradeService {

    @Autowired
    private StudentGradeRepository studentGradeRepository;

    // Get student grade by ID
    public StudentGradeDTO getStudentGradeById(Long gradeId) {
        Optional<StudentGrade> studentGradeOptional = studentGradeRepository.findById(gradeId);
        if (!studentGradeOptional.isPresent()) {
            throw new StudentGradeNotFoundException("Student grade not found with ID: " + gradeId);
        }

        StudentGrade studentGrade = studentGradeOptional.get();
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
        studentGradeDTO.setGradeId(studentGrade.getGradeId());
        studentGradeDTO.setEnrollmentId(studentGrade.getEnrollment());
        studentGradeDTO.setAssignmentId(studentGrade.getAssignment());
        studentGradeDTO.setGrade(studentGrade.getGrade());
        return studentGradeDTO;
    }

    // Get student grades by enrollment ID
    public List<StudentGradeDTO> getStudentGradesByEnrollmentId(Long enrollmentId) {
        List<StudentGrade> studentGradeList = studentGradeRepository.findByEnrollmentEnrollmentId(enrollmentId);

        // Convert StudentGrade entities to StudentGradeDTOs
        List<StudentGradeDTO> studentGradeDTOList = studentGradeList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return studentGradeDTOList;
    }

    // Convert StudentGrade entity to StudentGradeDTO
    private StudentGradeDTO convertToDTO(StudentGrade studentGrade) {
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
        studentGradeDTO.setGradeId(studentGrade.getGradeId());
        studentGradeDTO.setEnrollmentId(studentGrade.getEnrollment().getEnrollmentId());
        studentGradeDTO.setAssignmentId(studentGrade.getAssignment().getAssignmentId());
        studentGradeDTO.setGrade(studentGrade.getGrade());
        return studentGradeDTO;
    }
}
