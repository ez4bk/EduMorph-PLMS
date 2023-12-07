package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.EnrollmentDTO;
import com.rocket.edumorphplms.entity.Enrollment;
import com.rocket.edumorphplms.repository.CourseRepository;
import com.rocket.edumorphplms.repository.EnrollmentRepository;
import com.rocket.edumorphplms.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnrollmentServiceTest {


    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testGetEnrollmentsByCourseId() {

        // Create a new Enrollment entity
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentId(1L);
        enrollment.setUser(userRepository.findById(1L).get());
        enrollment.setCourse(courseRepository.findById(1L).get());
        int gradeValue = 90; // Replace with your actual grade value
        BigDecimal totalGrade = BigDecimal.valueOf(gradeValue);
        enrollment.setTotalGrade(totalGrade);
        enrollmentRepository.save(enrollment);

        // Get the enrollments by courseId from the repository
        List<Enrollment> enrollmentList = enrollmentRepository.findByCourseCourseId(1L);

        // Convert Enrollment entities to EnrollmentDTOs
        List<EnrollmentDTO> enrollmentDTOList = enrollmentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        // Verify that the EnrollmentDTO list is the same as the original Enrollment list
        assertEquals(enrollmentDTOList.get(0).getEnrollmentId(), enrollmentList.get(0).getEnrollmentId());
    }

    private EnrollmentDTO convertToDTO(Enrollment enrollment) {
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());
        enrollmentDTO.setUserId(enrollment.getUser().getUserId());
        enrollmentDTO.setCourseId(enrollment.getCourse().getCourseId());
        enrollmentDTO.setTotalGrade(enrollment.getTotalGrade());
        return enrollmentDTO;
    }
}
