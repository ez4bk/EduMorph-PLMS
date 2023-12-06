package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.StudentGradeDTO;
import com.rocket.edumorphplms.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-grades")
public class StudentGradeController {

    @Autowired
    private StudentGradeService studentGradeService;

    // Get StudentGrade by ID
    @GetMapping("/{gradeId}")
    public ResponseEntity<StudentGradeDTO> getStudentGradeById(@PathVariable Long gradeId) {
        StudentGradeDTO studentGradeDTO = studentGradeService.getStudentGradeById(gradeId);
        if (studentGradeDTO != null) {
            return new ResponseEntity<>(studentGradeDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
