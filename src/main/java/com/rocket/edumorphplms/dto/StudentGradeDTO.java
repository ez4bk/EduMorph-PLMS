package com.rocket.edumorphplms.dto;

public class StudentGradeDTO {
    private Long gradeId;
    private Long enrollmentId;
    private Long assignmentId;
    private Double grade;

    // Constructors
    public StudentGradeDTO() {
    }

    public StudentGradeDTO(Long gradeId, Long enrollmentId, Long assignmentId, Double grade) {
        this.gradeId = gradeId;
        this.enrollmentId = enrollmentId;
        this.assignmentId = assignmentId;
        this.grade = grade;
    }

    // Getters and Setters
    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
