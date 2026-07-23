package com.sushmitha.smartinboxguardianbackend.dto;
import com.sushmitha.smartinboxguardianbackend.enums.EmailCategory;


public class EmailDTO {

    private String from;
    private String subject;
    private String snippet;
    private EmailCategory category;

    public EmailDTO() {
    }

    public EmailDTO(String from,
                    String subject,
                    String snippet,
                    EmailCategory category) {

        this.from = from;
        this.subject = subject;
        this.snippet = snippet;
        this.category = category;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public EmailCategory getCategory() {
        return category;
    }

    public void setCategory(EmailCategory category) {
        this.category = category;
    }
}