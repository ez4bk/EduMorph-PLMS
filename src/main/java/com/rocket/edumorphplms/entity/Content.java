package com.rocket.edumorphplms.entity;

import jakarta.persistence.*;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @ManyToOne
    @JoinColumn(name = "Course_ID")
    private Course course;

    @Column(nullable = false)
    private String contentName;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Content() {
        // Default constructor
    }

    public Content(Course course, String contentName, String content) {
        this.course = course;
        this.contentName = contentName;
        this.content = content;
    }

    // Getter and setter methods
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
