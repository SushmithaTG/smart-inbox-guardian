package com.sushmitha.smartinboxguardianbackend.controller;

import com.google.api.services.gmail.Gmail;
import com.sushmitha.smartinboxguardianbackend.gmail.GmailServiceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gmail")
public class GmailController {

    private final GmailServiceFactory gmailServiceFactory;

    public GmailController(GmailServiceFactory gmailServiceFactory) {
        this.gmailServiceFactory = gmailServiceFactory;
    }

    @GetMapping("/authorize")
    public String authorize() throws Exception {

        Gmail gmail = gmailServiceFactory.getGmailService();

        return "Connected Successfully! Gmail Service = "
                + gmail.users().getProfile("me").execute().getEmailAddress();
    }
}