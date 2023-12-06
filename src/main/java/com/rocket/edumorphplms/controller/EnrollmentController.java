package com.rocket.edumorphplms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rocket.edumorphplms.dto.EnrollmentDTO;
import com.rocket.edumorphplms.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentDTO createEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        return enrollmentService.createEnrollment(enrollmentDTO);
    }

    @GetMapping("/{enrollmentId}")
    public EnrollmentDTO getEnrollmentById(@PathVariable Long enrollmentId) {
        return enrollmentService.getEnrollmentById(enrollmentId);
    }

}
