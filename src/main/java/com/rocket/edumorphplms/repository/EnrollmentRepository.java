package com.rocket.edumorphplms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.entity.Enrollment;
import com.rocket.edumorphplms.entity.User;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUser(User user);
    List<Enrollment> findByCourse(Course course);
    // Create a custom query method to find enrollments by user ID
    List<Enrollment> findByUserUserId(Long userId);
    // Create a custom query method to find enrollments by course ID
    List<Enrollment> findByCourseCourseId(Long courseId);
}
