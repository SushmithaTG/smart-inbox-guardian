package com.sushmitha.smartinboxguardianbackend.dto;

public class EmailDTO {

    private String from;
    private String subject;
    private String snippet;

    public EmailDTO() {
    }

    public EmailDTO(String from, String subject, String snippet) {
        this.from = from;
        this.subject = subject;
        this.snippet = snippet;
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
}