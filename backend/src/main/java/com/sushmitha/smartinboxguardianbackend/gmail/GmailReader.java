package com.sushmitha.smartinboxguardianbackend.gmail;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import org.springframework.stereotype.Component;

@Component
public class GmailReader {

    private final GmailServiceFactory gmailServiceFactory;

    public GmailReader(GmailServiceFactory gmailServiceFactory) {
        this.gmailServiceFactory = gmailServiceFactory;
    }

    public ListMessagesResponse getMessages() throws Exception {

        Gmail gmail = gmailServiceFactory.getGmailService();

        return gmail.users()
                .messages()
                .list("me")
                .setMaxResults(10L)
                .execute();
    }
}