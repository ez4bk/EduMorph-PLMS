package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.AssignmentDTO;
import com.rocket.edumorphplms.service.AssignmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // Create Assignment
    @PostMapping("/create")
    public ResponseEntity<AssignmentDTO> createAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        AssignmentDTO createdAssignment = assignmentService.createAssignment(assignmentDTO);
        return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
    }

    // Get Assignment by ID
    @GetMapping("/{assignmentId}")
    public ResponseEntity<AssignmentDTO> getAssignmentById(@PathVariable Long assignmentId) {
        AssignmentDTO assignmentDTO = assignmentService.getAssignmentById(assignmentId);
        if (assignmentDTO != null) {
            return new ResponseEntity<>(assignmentDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get Assignments by Course ID
    @GetMapping("/byCourse/{courseId}")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentsByCourseId(@PathVariable Long courseId) {
        List<AssignmentDTO> assignments = assignmentService.getAssignmentsByCourseId(courseId);
        if (!assignments.isEmpty()) {
            return new ResponseEntity<>(assignments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

