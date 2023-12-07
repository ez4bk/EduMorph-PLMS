package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.AssignmentDTO;
import com.rocket.edumorphplms.entity.Assignment;
import com.rocket.edumorphplms.repository.AssignmentRepository;
import com.rocket.edumorphplms.service.AssignmentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssignmentServiceTest {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Test
    void testGetAssignmentsByCourseId() {
        // Given
        Long courseId = 1L;

        // When
        List<AssignmentDTO> assignmentDTOs = assignmentService.getAssignmentsByCourseId(courseId);

        // Then
        assertEquals(1L, assignmentDTOs.get(0).getAssignmentId());
        assertEquals(courseId, assignmentDTOs.get(0).getCourseId());
        assertEquals("Assignment 1", assignmentDTOs.get(0).getTitle());
        assertEquals("Description for Assignment 1", assignmentDTOs.get(0).getDescription());
    }

    @Test
    void testGetAssignmentById() {
        // Given
        Long assignmentId = 1L;

        // When
        Optional<Assignment> assignmentOptional = assignmentRepository.findById(assignmentId);
        Assignment assignment = assignmentOptional.get();
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setAssignmentId(assignment.getAssignmentId());
        assignmentDTO.setCourseId(assignment.getCourseId());
        assignmentDTO.setTitle(assignment.getTitle());
        assignmentDTO.setDescription(assignment.getDescription());
        assignmentDTO.setDueDate(assignment.getDueDate());

        // Then
        assertEquals(assignmentDTO.getAssignmentId(), assignmentService.getAssignmentById(assignmentId).getAssignmentId());
    }
}
