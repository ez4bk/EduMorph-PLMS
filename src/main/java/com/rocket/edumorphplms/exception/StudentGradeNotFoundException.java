package com.rocket.edumorphplms.exception;

public class StudentGradeNotFoundException extends RuntimeException {

    public StudentGradeNotFoundException(String message) {
        super(message);
    }

    public StudentGradeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
