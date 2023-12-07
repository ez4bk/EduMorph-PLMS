package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.AssignmentDTO;
import com.rocket.edumorphplms.service.AssignmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@Api(tags = "Assignment Controller")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // Create Assignment
    @PostMapping("/create")
    @ApiOperation(value = "Create Assignment", notes = "Create a new assignment")
    public ResponseEntity<AssignmentDTO> createAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        AssignmentDTO createdAssignment = assignmentService.createAssignment(assignmentDTO);
        return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
    }

    // Get Assignment by ID
    @GetMapping("/{assignmentId}")
    @ApiOperation(value = "Get Assignment by ID", notes = "Retrieve an assignment by its ID")
    public ResponseEntity<AssignmentDTO> getAssignmentById(@PathVariable Long assignmentId) {
        AssignmentDTO assignmentDTO = assignmentService.getAssignmentById(assignmentId);
        if (assignmentDTO != null) {
            return new ResponseEntity<>(assignmentDTO, HttpStatus.OK);
        } else {
            // Return a NOT_FOUND response if the assignment does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get Assignments by Course ID
    @GetMapping("/byCourse/{courseId}")
    @ApiOperation(value = "Get Assignments by Course ID", notes = "Retrieve assignments by course ID")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentsByCourseId(@PathVariable Long courseId) {
        List<AssignmentDTO> assignments = assignmentService.getAssignmentsByCourseId(courseId);
        if (!assignments.isEmpty()) {
            return new ResponseEntity<>(assignments, HttpStatus.OK);
        } else {
            // Return a NOT_FOUND response if no assignments are found for the course
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
