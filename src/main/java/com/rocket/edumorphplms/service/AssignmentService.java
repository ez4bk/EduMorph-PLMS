package com.rocket.edumorphplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.edumorphplms.dto.AssignmentDTO;
import com.rocket.edumorphplms.entity.Assignment;
import com.rocket.edumorphplms.repository.AssignmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<AssignmentDTO> getAssignmentsByCourseId(Long courseId) {
        List<Assignment> assignments = assignmentRepository.findByCourse_CourseId(courseId);
        return assignments.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    private AssignmentDTO convertToDTO(Assignment assignment) {
        return new AssignmentDTO(
            assignment.getAssignmentId(),
            assignment.getCourseId(),
            assignment.getTitle(),
            assignment.getDescription(),
            assignment.getDueDate()
        );
    }

    public AssignmentDTO createAssignment(AssignmentDTO assignmentDTO) {
        Assignment assignment = new Assignment();
        // assignment.setCourse(assignmentDTO.getCourseDTO());
        assignment.setTitle(assignmentDTO.getTitle());
        assignment.setDescription(assignmentDTO.getDescription());
        assignment.setDueDate(assignmentDTO.getDueDate());

        assignment = assignmentRepository.save(assignment);

        assignmentDTO.setAssignmentId(assignment.getAssignmentId());
        return assignmentDTO;
    }

    public AssignmentDTO getAssignmentById(Long assignmentId) {
        Optional<Assignment> assignmentOptional = assignmentRepository.findById(assignmentId);
            Assignment assignment = assignmentOptional.get();
            AssignmentDTO assignmentDTO = new AssignmentDTO();
            assignmentDTO.setAssignmentId(assignment.getAssignmentId());
            assignmentDTO.setCourseId(assignment.getCourseId());
            assignmentDTO.setTitle(assignment.getTitle());
            assignmentDTO.setDescription(assignment.getDescription());
            assignmentDTO.setDueDate(assignment.getDueDate());
            return assignmentDTO;
        
    }

}
