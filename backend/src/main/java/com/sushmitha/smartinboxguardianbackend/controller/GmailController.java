package com.sushmitha.smartinboxguardianbackend.controller;

import java.util.List;
import com.sushmitha.smartinboxguardianbackend.dto.EmailDTO;
import com.sushmitha.smartinboxguardianbackend.gmail.GmailReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/gmail")
public class GmailController {

    private final GmailReader gmailReader;

    public GmailController(GmailReader gmailReader) {
        this.gmailReader = gmailReader;
    }

    @GetMapping("/messages")
    public List<EmailDTO> getMessages(
            @RequestParam(defaultValue = "10") Long limit) throws Exception {

        return gmailReader.getMessages(limit);
    }

    @GetMapping("/search")
    public List<EmailDTO> searchEmails(
            @RequestParam String query) throws Exception {

        return gmailReader.searchMessages(query);
    }
}