package com.rocket.edumorphplms.dto;

import java.util.List;

public class AccountInfoDTO {
    private Long id;
    private String email;
    private String password;
    private List<CourseDTO> coursesTaken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CourseDTO> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(List<CourseDTO> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }
}
