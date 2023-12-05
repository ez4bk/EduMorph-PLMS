package com.rocket.edumorphplms.dto;

import com.rocket.edumorphplms.entity.StudentGrade;

public class GradeDTO {
    private Long gradeId;
    private double score;
    
    public GradeDTO() {
        // Default constructor
    }
    
    // Constructor to derive GradeDTO from StudentGrade
    public GradeDTO(StudentGrade studentGrade) {
        this.gradeId = studentGrade.getGradeId();
        this.score = studentGrade.getGrade().doubleValue();
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    // Getter and setter for gradeName (You can implement your logic here)

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
