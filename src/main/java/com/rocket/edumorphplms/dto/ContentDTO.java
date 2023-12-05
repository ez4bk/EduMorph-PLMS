package com.rocket.edumorphplms.dto;

import com.rocket.edumorphplms.entity.Content;

public class ContentDTO {
    private Long contentId;
    private String contentName;
    private String content;
    
    public ContentDTO() {
        // Default constructor
    }
    
    public ContentDTO(Long contentId, String contentName, String content) {
        this.contentId = contentId;
        this.contentName = contentName;
        this.content = content;
    }

    
    public ContentDTO(Content content) {
        // Initialize ContentDTO fields based on Content fields
        this.contentId = content.getContentId();
        this.contentName = content.getContentName();
        this.content = content.getContent();
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
