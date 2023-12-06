package com.rocket.edumorphplms.dto;

import com.rocket.edumorphplms.entity.Enrollment;
import com.rocket.edumorphplms.entity.Assignment;


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

    // Custom setters
    public void setEnrollmentId(Enrollment enrollment) {
        if (enrollment != null) {
            this.enrollmentId = enrollment.getEnrollmentId();
        }
    }

    public void setAssignmentId(Assignment assignment) {
        if (assignment != null) {
            this.assignmentId = assignment.getAssignmentId();
        }
    }
}
