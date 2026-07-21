package com.sushmitha.smartinboxguardianbackend.gmail;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.services.gmail.Gmail;
import org.springframework.stereotype.Component;

@Component
public class GmailServiceFactory {

    private final GmailAuthorization gmailAuthorization;

    public GmailServiceFactory(GmailAuthorization gmailAuthorization) {
        this.gmailAuthorization = gmailAuthorization;
    }

    public Gmail getGmailService() throws Exception {

        Credential credential = gmailAuthorization.authorize();

        return new Gmail.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                com.google.api.client.json.gson.GsonFactory.getDefaultInstance(),
                credential)
                .setApplicationName(GmailConstants.APPLICATION_NAME)
                .build();
    }
}