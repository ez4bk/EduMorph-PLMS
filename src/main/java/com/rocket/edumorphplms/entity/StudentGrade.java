package com.rocket.edumorphplms.entity;

import jakarta.persistence.*;

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

    @Column(columnDefinition = "NUMERIC(5,2)")
    private Double grade;

    // Constructors
    public StudentGrade() {
    }

    public StudentGrade(Enrollment enrollment, Assignment assignment, Double grade) {
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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
