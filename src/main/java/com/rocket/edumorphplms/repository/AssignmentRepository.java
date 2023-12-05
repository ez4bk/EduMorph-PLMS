package com.rocket.edumorphplms.repository;

import com.rocket.edumorphplms.entity.Assignment;
import com.rocket.edumorphplms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourse(Course course);
}

