package com.rocket.edumorphplms.dto;

import java.util.List;

public class CourseDTO {
    private Long courseId;
    private String courseName;
    private String description;
    private UserDTO instructor;
    private List<UserDTO> enrolledStudents;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(UserDTO instructor) {
        this.instructor = instructor;
    }

    public List<UserDTO> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<UserDTO> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public CourseDTO(Long courseId, String courseName, String description, UserDTO instructor,
            List<UserDTO> enrolledStudents) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.instructor = instructor;
        this.enrolledStudents = enrolledStudents;
    }

    public CourseDTO() {
    }

    
}
