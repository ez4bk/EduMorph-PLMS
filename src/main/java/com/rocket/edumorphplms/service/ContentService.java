package com.rocket.edumorphplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rocket.edumorphplms.dto.ContentDTO;
import com.rocket.edumorphplms.entity.Content;
import com.rocket.edumorphplms.entity.Course;
import com.rocket.edumorphplms.repository.ContentRepository;
import com.rocket.edumorphplms.repository.CourseRepository;

import java.util.List;

@Service
public class ContentService {
    
    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CourseRepository courseRepository;


    public ContentDTO createContent(ContentDTO contentDTO) {
        // Check if the associated course exists
        Optional<Course> courseOptional = courseRepository.findById(contentDTO.getCourseId());

            // Map ContentDTO to Content entity
            Content content = new Content();
            content.setCourse(courseOptional.get());
            content.setContentName(contentDTO.getContentName());
            content.setContent(contentDTO.getContent());

            // Save the content to the repository
            Content savedContent = contentRepository.save(content);

            // Map the saved Content back to ContentDTO
            ContentDTO savedContentDTO = new ContentDTO();
            savedContentDTO.setContentId(savedContent.getContentId());
            savedContentDTO.setCourseId(savedContent.getCourse().getCourseId());
            savedContentDTO.setContentName(savedContent.getContentName());
            savedContentDTO.setContent(savedContent.getContent());

            return savedContentDTO;
        
    }

    public ContentDTO getContentById(Long contentId) {
        // Retrieve content by contentId from the repository
        Optional<Content> contentOptional = contentRepository.findById(contentId);

            // Map the Content entity to ContentDTO
            Content content = contentOptional.get();
            ContentDTO contentDTO = new ContentDTO();
            contentDTO.setContentId(content.getContentId());
            contentDTO.setCourseId(content.getCourse().getCourseId());
            contentDTO.setContentName(content.getContentName());
            contentDTO.setContent(content.getContent());
            return contentDTO;
    }

    public List<ContentDTO> getContentsByCourseId(Long courseId) {
        List<Content> contentList = contentRepository.findByCourseCourseId(courseId);

        // Convert Content entities to ContentDTOs
        List<ContentDTO> contentDTOList = contentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return contentDTOList;
    }

    private ContentDTO convertToDTO(Content content) {
        ContentDTO contentDTO = new ContentDTO();
        contentDTO.setContentId(content.getContentId());
        contentDTO.setCourseId(content.getCourse().getCourseId());
        contentDTO.setContentName(content.getContentName());
        contentDTO.setContent(content.getContent());
        return contentDTO;
    }
}
