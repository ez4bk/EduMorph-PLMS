package com.rocket.edumorphplms.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "Instructor_ID")
    private User instructor;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Constructors
    public Course() {
    }

    public Course(String courseName, User instructor, String description) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.description = description;
    }

    // Getters and setters
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

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
