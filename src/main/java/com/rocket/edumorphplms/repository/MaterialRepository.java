package com.rocket.edumorphplms.repository;

import com.rocket.edumorphplms.entity.Content;
import com.rocket.edumorphplms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaterialRepository extends JpaRepository<Content, Long> {
    List<Content> findByCourse(Course course);
}
