package com.rocket.edumorphplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.edumorphplms.dto.StudentGradeDTO;
import com.rocket.edumorphplms.entity.StudentGrade;
import com.rocket.edumorphplms.repository.StudentGradeRepository;
import java.util.Optional;

@Service
public class StudentGradeService {

    @Autowired
    private StudentGradeRepository studentGradeRepository;

    public StudentGradeDTO getStudentGradeById(Long gradeId) {
        Optional<StudentGrade> studentGradeOptional = studentGradeRepository.findById(gradeId);

            StudentGrade studentGrade = studentGradeOptional.get();
            StudentGradeDTO studentGradeDTO = new StudentGradeDTO();
            studentGradeDTO.setGradeId(studentGrade.getGradeId());
            studentGradeDTO.setEnrollmentId(studentGrade.getEnrollment());
            studentGradeDTO.setAssignmentId(studentGrade.getAssignment());
            studentGradeDTO.setGrade(studentGrade.getGrade());
            return studentGradeDTO;

    }

}
