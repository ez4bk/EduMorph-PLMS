package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.StudentGradeDTO;
import com.rocket.edumorphplms.service.StudentGradeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/student-grades")
@CrossOrigin(origins = "*")
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

    // Get StudentGrades by Enrollment ID
    @GetMapping("/byEnrollment/{enrollmentId}")
    public ResponseEntity<List<StudentGradeDTO>> getStudentGradesByEnrollmentId(@PathVariable Long enrollmentId) {
        List<StudentGradeDTO> studentGradeList = studentGradeService.getStudentGradesByEnrollmentId(enrollmentId);
        if (!studentGradeList.isEmpty()) {
            return ResponseEntity.ok(studentGradeList);
        }
        return ResponseEntity.notFound().build();
    }
}
