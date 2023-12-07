package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.EnrollmentDTO;
import com.rocket.edumorphplms.service.EnrollmentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Create Enrollment
    @PostMapping
    @ApiOperation(value = "Create Enrollment", notes = "Create a new enrollment")
    public ResponseEntity<EnrollmentDTO> createEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        // Call the service to create an enrollment and return a response with the created enrollment
        EnrollmentDTO createdEnrollment = enrollmentService.createEnrollment(enrollmentDTO);
        return new ResponseEntity<>(createdEnrollment, HttpStatus.CREATED);
    }

    // Get Enrollment by ID
    @GetMapping("/{enrollmentId}")
    @ApiOperation(value = "Get Enrollment by ID", notes = "Retrieve an enrollment by its ID")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long enrollmentId) {
        // Call the service to retrieve an enrollment by its ID
        EnrollmentDTO enrollmentDTO = enrollmentService.getEnrollmentById(enrollmentId);
        if (enrollmentDTO != null) {
            return new ResponseEntity<>(enrollmentDTO, HttpStatus.OK);
        } else {
            // Return a NOT_FOUND response if the enrollment does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get Enrollments by Course ID
    @GetMapping("/byCourse/{courseId}")
    @ApiOperation(value = "Get Enrollments by Course ID", notes = "Retrieve enrollments by course ID")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        // Call the service to retrieve enrollments by the specified course ID
        List<EnrollmentDTO> enrollmentList = enrollmentService.getEnrollmentsByCourseId(courseId);
        if (!enrollmentList.isEmpty()) {
            return ResponseEntity.ok(enrollmentList);
        }
        // Return a NOT_FOUND response if no enrollments are found for the course
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByUserId(@PathVariable Long userId) {
        List<EnrollmentDTO> enrollmentList = enrollmentService.getEnrollmentsByUserId(userId);
        if (!enrollmentList.isEmpty()) {
            return ResponseEntity.ok(enrollmentList);
        }
        return ResponseEntity.notFound().build();
    }
}
