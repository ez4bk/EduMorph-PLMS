package com.rocket.edumorphplms.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @ManyToOne
    @JoinColumn(name = "Enrollment_ID")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "Assignment_ID")
    private Assignment assignment;

    @Column(precision = 5, scale = 2)
    private BigDecimal grade;

    // Constructors
    public StudentGrade() {
    }

    public StudentGrade(Enrollment enrollment, Assignment assignment, BigDecimal grade) {
        this.enrollment = enrollment;
        this.assignment = assignment;
        this.grade = grade;
    }

    // Getters and setters
    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
}
