package com.rocket.edumorphplms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    // Custom query to find students by course
    List<User> findByEnrollmentsCourse(Course course);
}
