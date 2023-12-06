package com.rocket.edumorphplms.repository;

import com.rocket.edumorphplms.entity.StudentGrade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {

    List<StudentGrade> findByEnrollmentEnrollmentId(Long enrollmentId);

}
