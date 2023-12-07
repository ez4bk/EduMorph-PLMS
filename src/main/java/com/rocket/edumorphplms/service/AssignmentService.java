package com.rocket.edumorphplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;

import com.rocket.edumorphplms.dto.AssignmentDTO;
import com.rocket.edumorphplms.entity.Assignment;
import com.rocket.edumorphplms.exception.AssignmentNotFoundException;
import com.rocket.edumorphplms.repository.AssignmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    // Get Assignments by Course ID
    public List<AssignmentDTO> getAssignmentsByCourseId(Long courseId) {
        // Retrieve assignments from the repository by course ID
        List<Assignment> assignments = assignmentRepository.findByCourse_CourseId(courseId);
        
        // Convert the list of Assignment entities to AssignmentDTOs
        return assignments.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    // Convert Assignment entity to AssignmentDTO
    private AssignmentDTO convertToDTO(Assignment assignment) {
        return new AssignmentDTO(
            assignment.getAssignmentId(),
            assignment.getCourseId(),
            assignment.getTitle(),
            assignment.getDescription(),
            assignment.getDueDate()
        );
    }

    // Create Assignment
    public AssignmentDTO createAssignment(AssignmentDTO assignmentDTO) {
        Assignment assignment = new Assignment();
        assignment.setTitle(assignmentDTO.getTitle());
        assignment.setDescription(assignmentDTO.getDescription());
        assignment.setDueDate(assignmentDTO.getDueDate());

        // Save the new assignment to the repository
        assignment = assignmentRepository.save(assignment);

        assignmentDTO.setAssignmentId(assignment.getAssignmentId());
        return assignmentDTO;
    }

    // Get Assignment by ID
    public AssignmentDTO getAssignmentById(Long assignmentId) {
        try {
            Optional<Assignment> assignmentOptional = assignmentRepository.findById(assignmentId);
            if (assignmentOptional.isPresent()) {
                Assignment assignment = assignmentOptional.get();
                AssignmentDTO assignmentDTO = new AssignmentDTO();
                assignmentDTO.setAssignmentId(assignment.getAssignmentId());
                assignmentDTO.setCourseId(assignment.getCourseId());
                assignmentDTO.setTitle(assignment.getTitle());
                assignmentDTO.setDescription(assignment.getDescription());
                assignmentDTO.setDueDate(assignment.getDueDate());
                return assignmentDTO;
            } else {
                // Throw a custom exception if the assignment with the given ID is not found
                throw new AssignmentNotFoundException("Assignment not found with ID: " + assignmentId);
            }
        } catch (EmptyResultDataAccessException ex) {
            // Handle empty result exception (e.g., when deleting an assignment that doesn't exist)
            throw new AssignmentNotFoundException("Assignment not found with ID: " + assignmentId);
        }
    }
}
