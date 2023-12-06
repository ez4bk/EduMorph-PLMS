package com.rocket.edumorphplms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rocket.edumorphplms.service.ContentService;
import com.rocket.edumorphplms.dto.ContentDTO;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/create")
    public ResponseEntity<ContentDTO> createContent(@RequestBody ContentDTO contentDTO) {
        ContentDTO createdContent = contentService.createContent(contentDTO);
        if (createdContent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContent);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ContentDTO> getContentById(@PathVariable Long contentId) {
        ContentDTO content = contentService.getContentById(contentId);
        if (content != null) {
            return ResponseEntity.ok(content);
        }
        return ResponseEntity.notFound().build();
    }
}
