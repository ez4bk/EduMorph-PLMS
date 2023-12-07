package com.rocket.edumorphplms.service;

import com.rocket.edumorphplms.dto.CourseDTO;
import com.rocket.edumorphplms.dto.UserDTO;
import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.entity.Enrollment;
import com.rocket.edumorphplms.entity.User;
import com.rocket.edumorphplms.exception.CourseNotFoundException;
import com.rocket.edumorphplms.repository.CourseRepository;
import com.rocket.edumorphplms.repository.EnrollmentRepository;
import com.rocket.edumorphplms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new course
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = convertToCourseEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return convertToCourseDTO(savedCourse);
    }

    // Get all courses
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());
    }

    // Get courses taught by a specific instructor
    public List<CourseDTO> getCoursesByInstructor(UserDTO instructorDTO) {
        User instructor = convertToUserEntity(instructorDTO);
        List<Course> courses = courseRepository.findByInstructor(instructor);
        return courses.stream()
                .map(this::convertToCourseDTO)
                .collect(Collectors.toList());
    }

    // Get a course by its ID
    public CourseDTO getCourseById(Long courseId) throws CourseNotFoundException {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));
        CourseDTO courseDTO = convertToCourseDTO(course);
        List<UserDTO> enrolledStudents = getEnrolledStudents(course); // Populate enrolled students
        courseDTO.setEnrolledStudents(enrolledStudents);
        return courseDTO;
    }

    // Helper method to get enrolled students for a course
    public List<UserDTO> getEnrolledStudents(Course course) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourse(course);
        List<Long> enrolledStudentIds = enrollments.stream()
                .map(enrollment -> enrollment.getUser().getUserId())
                .collect(Collectors.toList());
        List<User> enrolledStudents = userRepository.findAllById(enrolledStudentIds);
        return enrolledStudents.stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    // Convert Course entity to CourseDTO
    private CourseDTO convertToCourseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setInstructor(convertToUserDTO(course.getInstructor()));
        return courseDTO;
    }

    // Convert CourseDTO to Course entity
    private Course convertToCourseEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setDescription(courseDTO.getDescription());
        course.setInstructor(convertToUserEntity(courseDTO.getInstructor()));
        return course;
    }

    // Convert User entity to UserDTO
    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());
        return userDTO;
    }

    // Convert UserDTO to User entity
    private User convertToUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setUserType(userDTO.getUserType());
        return user;
    }
}
