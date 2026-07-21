package com.sushmitha.smartinboxguardianbackend.gmail;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Component
public class GmailAuthorization {

    private static final JsonFactory JSON_FACTORY =
            GsonFactory.getDefaultInstance();

    private NetHttpTransport getTransport() throws GeneralSecurityException, IOException {
        return GoogleNetHttpTransport.newTrustedTransport();
    }

    private GoogleClientSecrets getClientSecrets() throws IOException {

        InputStream in = getClass().getResourceAsStream("/credentials.json");

        if (in == null) {
            throw new IOException("credentials.json not found");
        }

        return GoogleClientSecrets.load(
                JSON_FACTORY,
                new InputStreamReader(in)
        );
    }
    public Credential authorize()
            throws IOException, GeneralSecurityException {

        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        getTransport(),
                        JSON_FACTORY,
                        getClientSecrets(),
                        GmailConstants.SCOPES
                )
                        .setDataStoreFactory(
                                new FileDataStoreFactory(
                                        new File(GmailConstants.TOKENS_DIRECTORY_PATH)
                                )
                        )
                        .setAccessType("offline")
                        .build();

        LocalServerReceiver receiver =
                new LocalServerReceiver.Builder()
                        .setPort(8889)
                        .build();

        return new AuthorizationCodeInstalledApp(flow, receiver)
                .authorize("user");
    }

}