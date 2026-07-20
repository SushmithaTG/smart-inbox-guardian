package com.sushmitha.smartinboxguardianbackend.controller;

import com.sushmitha.smartinboxguardianbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sushmitha.smartinboxguardianbackend.dto.EmailRequestDTO;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequestDTO emailRequest) {

        emailService.sendEmail(
                emailRequest.getTo(),
                emailRequest.getSubject(),
                emailRequest.getBody()
        );

        return "Email sent successfully!";
    }
}