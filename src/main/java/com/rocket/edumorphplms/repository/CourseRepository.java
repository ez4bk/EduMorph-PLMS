package com.rocket.edumorphplms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.entity.User;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor(User instructor);
    
}

