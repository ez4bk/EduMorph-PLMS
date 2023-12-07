package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.CourseDTO;
import com.rocket.edumorphplms.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create Course
    @PostMapping
    @ApiOperation(value = "Create Course", notes = "Create a new course")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO createdCourse = courseService.createCourse(courseDTO);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    // Get Course by ID
    @GetMapping("/{courseId}")
    @ApiOperation(value = "Get Course by ID", notes = "Retrieve a course by its ID")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long courseId) {
        CourseDTO courseDTO = courseService.getCourseById(courseId);
        if (courseDTO != null) {
            return new ResponseEntity<>(courseDTO, HttpStatus.OK);
        } else {
            // Return a NOT_FOUND response if the course does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Courses
    @GetMapping
    @ApiOperation(value = "Get All Courses", notes = "Retrieve all courses")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
