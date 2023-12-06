package com.rocket.edumorphplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.edumorphplms.dto.EnrollmentDTO;
import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.entity.Enrollment;
import com.rocket.edumorphplms.entity.User;
import com.rocket.edumorphplms.repository.CourseRepository;
import com.rocket.edumorphplms.repository.EnrollmentRepository;
import com.rocket.edumorphplms.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDTO) {
        // Check if the associated user and course exist
        Optional<User> userOptional = userRepository.findById(enrollmentDTO.getUserId());
        Optional<Course> courseOptional = courseRepository.findById(enrollmentDTO.getCourseId());

            // Map EnrollmentDTO to Enrollment entity
            Enrollment enrollment = new Enrollment();
            enrollment.setUser(userOptional.get());
            enrollment.setCourse(courseOptional.get());
            enrollment.setTotalGrade(enrollmentDTO.getTotalGrade());

            // Save the enrollment to the repository
            Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

            // Map the saved Enrollment back to EnrollmentDTO
            EnrollmentDTO savedEnrollmentDTO = new EnrollmentDTO();
            savedEnrollmentDTO.setEnrollmentId(savedEnrollment.getEnrollmentId());
            savedEnrollmentDTO.setUserId(savedEnrollment.getUser().getUserId());
            savedEnrollmentDTO.setCourseId(savedEnrollment.getCourse().getCourseId());
            savedEnrollmentDTO.setTotalGrade(savedEnrollment.getTotalGrade());

            return savedEnrollmentDTO;


    }

    public EnrollmentDTO getEnrollmentById(Long enrollmentId) {
        // Retrieve enrollment by enrollmentId from the repository
        Optional<Enrollment> enrollmentOptional = enrollmentRepository.findById(enrollmentId);

            // Map the Enrollment entity to EnrollmentDTO
            Enrollment enrollment = enrollmentOptional.get();
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
            enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());
            enrollmentDTO.setUserId(enrollment.getUser().getUserId());
            enrollmentDTO.setCourseId(enrollment.getCourse().getCourseId());
            enrollmentDTO.setTotalGrade(enrollment.getTotalGrade());
            return enrollmentDTO;
    }

    public List<EnrollmentDTO> getEnrollmentsByUserId(Long userId) {
        List<Enrollment> enrollmentList = enrollmentRepository.findByUserUserId(userId);

        // Convert Enrollment entities to EnrollmentDTOs
        List<EnrollmentDTO> enrollmentDTOList = enrollmentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return enrollmentDTOList;
    }

    private EnrollmentDTO convertToDTO(Enrollment enrollment) {
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setEnrollmentId(enrollment.getEnrollmentId());
        enrollmentDTO.setUserId(enrollment.getUser().getUserId());
        enrollmentDTO.setCourseId(enrollment.getCourse().getCourseId());
        enrollmentDTO.setTotalGrade(enrollment.getTotalGrade());
        return enrollmentDTO;
    }

    public List<EnrollmentDTO> getEnrollmentsByCourseId(Long courseId) {
        // Retrieve enrollments by course ID from the repository
        List<Enrollment> enrollmentList = enrollmentRepository.findByCourseCourseId(courseId);

        // Convert Enrollment entities to EnrollmentDTOs
        List<EnrollmentDTO> enrollmentDTOList = enrollmentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return enrollmentDTOList;
    }

}
