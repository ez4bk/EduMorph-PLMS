package com.rocket.edumorphplms.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Course_ID")
    private Course course;

    @Column(precision = 5, scale = 2)
    private BigDecimal totalGrade;

    // Constructors
    public Enrollment() {
    }

    public Enrollment(User user, Course course, BigDecimal totalGrade) {
        this.user = user;
        this.course = course;
        this.totalGrade = totalGrade;
    }

    // Getters and setters
    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public BigDecimal getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(BigDecimal totalGrade) {
        this.totalGrade = totalGrade;
    }
}
