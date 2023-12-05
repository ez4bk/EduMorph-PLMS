package com.rocket.edumorphplms.service;

import com.rocket.edumorphplms.dto.CourseDTO;
import com.rocket.edumorphplms.dto.AccountInfoDTO;
import com.rocket.edumorphplms.entity.User;
import com.rocket.edumorphplms.entity.Enrollment;
import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.repository.UserRepository;
import com.rocket.edumorphplms.repository.EnrollmentRepository;
import com.rocket.edumorphplms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public AccountInfoDTO getAccountInfo(String username) {
        // Fetch user details from UserRepository using a custom query
        User user = userRepository.findByEmail(username);

        if (user == null) {
            // Handle user not found
            return null;
        }

        // Fetch courses taken by the user from EnrollmentRepository using a custom query
        List<Enrollment> enrollments = enrollmentRepository.findByUser(user);

        // Fetch courses taught by the user from CourseRepository using a custom query
        List<Course> coursesTaught = courseRepository.findByInstructor(user);

        // Extract course information from enrollments and convert to CourseDTO
        List<CourseDTO> coursesTakenDTO = enrollments.stream()
            .map(enrollment -> convertToCourseDTO(enrollment.getCourse()))
            .collect(Collectors.toList());

        // Convert coursesTaught to CourseDTO if needed
        List<CourseDTO> coursesTaughtDTO = coursesTaught.stream()
            .map(course -> convertToCourseDTO(course))
            .collect(Collectors.toList());

        // Create an AccountInfoDTO and populate it with user details and courses taken
        AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
        accountInfoDTO.setId(user.getUserId());
        accountInfoDTO.setEmail(user.getEmail());
        accountInfoDTO.setPassword(user.getPassword());
        accountInfoDTO.setCoursesTaken(coursesTakenDTO);

        return accountInfoDTO;
    }

    // Method to convert Course to CourseDTO
    private CourseDTO convertToCourseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setDescription(course.getDescription());
    
        return courseDTO;
    }
}
