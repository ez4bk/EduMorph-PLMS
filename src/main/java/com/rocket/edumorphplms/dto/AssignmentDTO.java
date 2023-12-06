package com.rocket.edumorphplms.dto;

import java.time.LocalDate;

public class AssignmentDTO {
    private Long assignmentId;
    private CourseDTO courseDTO; // Use CourseDTO here
    private String title;
    private String description;
    private LocalDate dueDate;

    // Constructors
    public AssignmentDTO() {
    }

    public AssignmentDTO(Long assignmentId, CourseDTO courseDTO, String title, String description, LocalDate dueDate) {
        this.assignmentId = assignmentId;
        this.courseDTO = courseDTO;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
