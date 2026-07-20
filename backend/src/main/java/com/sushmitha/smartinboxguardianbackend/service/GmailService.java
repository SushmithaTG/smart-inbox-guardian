package com.sushmitha.smartinboxguardianbackend.service;

import org.springframework.stereotype.Service;

@Service
public class GmailService {

    public String testConnection() {
        return "Gmail API is configured successfully!";
    }
}