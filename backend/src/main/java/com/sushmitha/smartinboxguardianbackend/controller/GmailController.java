package com.sushmitha.smartinboxguardianbackend.controller;

import com.sushmitha.smartinboxguardianbackend.service.GmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gmail")
public class GmailController {

    @Autowired
    private GmailService gmailService;

    @GetMapping("/test")
    public String testConnection() {
        return gmailService.testConnection();
    }
}