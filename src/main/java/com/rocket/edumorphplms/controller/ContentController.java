package com.rocket.edumorphplms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rocket.edumorphplms.service.ContentService;
import com.rocket.edumorphplms.dto.ContentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    // Create Content
    @PostMapping("/create")
    @ApiOperation(value = "Create Content", notes = "Create a new content")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Content created successfully", response = ContentDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity<ContentDTO> createContent(@RequestBody ContentDTO contentDTO) {
        ContentDTO createdContent = contentService.createContent(contentDTO);
        if (createdContent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContent);
        }
        // Return an INTERNAL_SERVER_ERROR response if content creation fails
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    // Get Content by ID
    @GetMapping("/{contentId}")
    @ApiOperation(value = "Get Content by ID", notes = "Retrieve content by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Content retrieved successfully", response = ContentDTO.class),
            @ApiResponse(code = 404, message = "Content not found")
    })
    public ResponseEntity<ContentDTO> getContentById(@PathVariable Long contentId) {
        ContentDTO content = contentService.getContentById(contentId);
        if (content != null) {
            return ResponseEntity.ok(content);
        }
        // Return a NOT_FOUND response if the content does not exist
        return ResponseEntity.notFound().build();
    }

    // Get Content by Course ID
    @GetMapping("/byCourse/{courseId}")
    @ApiOperation(value = "Get Content by Course ID", notes = "Retrieve content by course ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Content retrieved successfully", response = ContentDTO.class),
            @ApiResponse(code = 404, message = "Content not found")
    })
    public ResponseEntity<List<ContentDTO>> getContentsByCourseId(@PathVariable Long courseId) {
        List<ContentDTO> contentList = contentService.getContentsByCourseId(courseId);
        if (!contentList.isEmpty()) {
            return ResponseEntity.ok(contentList);
        }
        // Return a NOT_FOUND response if no content is found for the course
        return ResponseEntity.notFound().build();
    }
}
