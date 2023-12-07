package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.EnrollmentDTO;
import com.rocket.edumorphplms.service.EnrollmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDTO> createEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        EnrollmentDTO createdEnrollment = enrollmentService.createEnrollment(enrollmentDTO);
        return new ResponseEntity<>(createdEnrollment, HttpStatus.CREATED);
    }

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long enrollmentId) {
        EnrollmentDTO enrollmentDTO = enrollmentService.getEnrollmentById(enrollmentId);
        if (enrollmentDTO != null) {
            return new ResponseEntity<>(enrollmentDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byCourse/{courseId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        List<EnrollmentDTO> enrollmentList = enrollmentService.getEnrollmentsByCourseId(courseId);
        if (!enrollmentList.isEmpty()) {
            return ResponseEntity.ok(enrollmentList);
        }
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
