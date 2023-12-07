package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.ContentDTO;
import com.rocket.edumorphplms.entity.Content;
import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.repository.ContentRepository;
import com.rocket.edumorphplms.repository.CourseRepository;
import com.rocket.edumorphplms.service.ContentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContentServiceTest {

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testCreateContent() {
        // Create a Course entity
        Course course = new Course();
        course.setCourseName("Test Course");
        courseRepository.save(course);

        // Create a ContentDTO
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setCourseId(course.getCourseId());
        contentDTO.setContentName("Test Content");
        contentDTO.setContent("Test Content");

        // Create a Content entity from the ContentDTO
        Content content = new Content();
        content.setCourse(course);
        content.setContentName(contentDTO.getContentName());
        content.setContent(contentDTO.getContent());

        // Save the Content entity to the repository
        contentRepository.save(content);

        // Get the ContentDTO from the repository
        ContentDTO savedContentDTO = contentService.getContentById(content.getContentId());

        // Verify that the ContentDTO is correct
        assertEquals(contentDTO.getCourseId(), savedContentDTO.getCourseId());
        assertEquals(contentDTO.getContentName(), savedContentDTO.getContentName());
        assertEquals(contentDTO.getContent(), savedContentDTO.getContent());
    }

    @Test
    public void testGetContentById() {
        // Create a Course entity
        Course course = new Course();
        course.setCourseName("Test Course");
        courseRepository.save(course);

        // Create a Content entity
        Content content = new Content();
        content.setCourse(course);
        content.setContentName("Test Content");
        content.setContent("Test Content");
        contentRepository.save(content);

        // Get the ContentDTO from the repository
        ContentDTO contentDTO = contentService.getContentById(content.getContentId());

        // Verify that the ContentDTO is correct
        assertEquals(content.getCourse().getCourseId(), contentDTO.getCourseId());
        assertEquals(content.getContentName(), contentDTO.getContentName());
        assertEquals(content.getContent(), contentDTO.getContent());
    }

    @Test
    public void testGetContentsByCourseId() {
        // Create a Course entity
        Course course = new Course();
        course.setCourseName("Test Course");
        courseRepository.save(course);

        // Create a Content entity
        Content content = new Content();
        content.setCourse(course);
        content.setContentName("Test Content");
        content.setContent("Test Content");
        contentRepository.save(content);

        // Get the list of ContentDTOs from the repository
        List<ContentDTO> contentDTOList = contentService.getContentsByCourseId(course.getCourseId());

        // Verify that the list of ContentDTOs is correct
        assertEquals(1, contentDTOList.size());
        assertEquals(content.getCourse().getCourseId(), contentDTOList.get(0).getCourseId());
        assertEquals(content.getContentName(), contentDTOList.get(0).getContentName());
        assertEquals(content.getContent(), contentDTOList.get(0).getContent());
    }
}
