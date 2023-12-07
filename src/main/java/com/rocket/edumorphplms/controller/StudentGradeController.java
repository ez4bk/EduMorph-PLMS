package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.StudentGradeDTO;
import com.rocket.edumorphplms.service.StudentGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-grades")
@Api(tags = "Student Grade Controller")
public class StudentGradeController {

    @Autowired
    private StudentGradeService studentGradeService;

    // Get StudentGrade by ID
    @GetMapping("/{gradeId}")
    @ApiOperation(value = "Get StudentGrade by ID", notes = "Retrieve a student grade by its ID")
    public ResponseEntity<StudentGradeDTO> getStudentGradeById(@PathVariable Long gradeId) {
        StudentGradeDTO studentGradeDTO = studentGradeService.getStudentGradeById(gradeId);
        if (studentGradeDTO != null) {
            return new ResponseEntity<>(studentGradeDTO, HttpStatus.OK);
        } else {
            // Return a NOT_FOUND response if the student grade does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get StudentGrades by Enrollment ID
    @GetMapping("/byEnrollment/{enrollmentId}")
    @ApiOperation(value = "Get StudentGrades by Enrollment ID", notes = "Retrieve student grades by enrollment ID")
    public ResponseEntity<List<StudentGradeDTO>> getStudentGradesByEnrollmentId(@PathVariable Long enrollmentId) {
        List<StudentGradeDTO> studentGradeList = studentGradeService.getStudentGradesByEnrollmentId(enrollmentId);
        if (!studentGradeList.isEmpty()) {
            return ResponseEntity.ok(studentGradeList);
        }
        // Return a NOT_FOUND response if no student grades are found for the enrollment
        return ResponseEntity.notFound().build();
    }
}
