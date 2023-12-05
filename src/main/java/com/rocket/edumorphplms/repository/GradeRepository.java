package com.rocket.edumorphplms.repository;

import com.rocket.edumorphplms.entity.StudentGrade;
import com.rocket.edumorphplms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GradeRepository extends JpaRepository<StudentGrade, Long> {
    List<StudentGrade> findByCourse(Course course);
}
