package com.sushmitha.smartinboxguardianbackend.gmail;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePartHeader;
import com.sushmitha.smartinboxguardianbackend.dto.EmailDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GmailReader {

    private final GmailServiceFactory gmailServiceFactory;

    public GmailReader(GmailServiceFactory gmailServiceFactory) {
        this.gmailServiceFactory = gmailServiceFactory;
    }

    public List<EmailDTO> getMessages(Long limit) throws Exception {

        Gmail gmail = gmailServiceFactory.getGmailService();

        ListMessagesResponse response = gmail.users()
                .messages()
                .list("me")
                .setMaxResults(limit)
                .execute();

        List<EmailDTO> emails = new ArrayList<>();

        if (response.getMessages() == null) {
            return emails;
        }

        for (Message msg : response.getMessages()) {

            Message fullMessage = gmail.users()
                    .messages()
                    .get("me", msg.getId())
                    .execute();

            String from = "";
            String subject = "";

            for (MessagePartHeader header : fullMessage.getPayload().getHeaders()) {

                if ("From".equalsIgnoreCase(header.getName())) {
                    from = header.getValue();
                }

                if ("Subject".equalsIgnoreCase(header.getName())) {
                    subject = header.getValue();
                }
            }

            emails.add(new EmailDTO(
                    from,
                    subject,
                    fullMessage.getSnippet()
            ));
        }

        return emails;
    }
    public List<EmailDTO> searchMessages(String query) throws Exception {

        Gmail gmail = gmailServiceFactory.getGmailService();

        ListMessagesResponse response = gmail.users()
                .messages()
                .list("me")
                .setQ(query)
                .setMaxResults(10L)
                .execute();

        List<EmailDTO> emails = new ArrayList<>();

        if (response.getMessages() == null) {
            return emails;
        }

        for (Message msg : response.getMessages()) {

            Message fullMessage = gmail.users()
                    .messages()
                    .get("me", msg.getId())
                    .execute();

            String from = "";
            String subject = "";

            for (MessagePartHeader header : fullMessage.getPayload().getHeaders()) {

                if ("From".equalsIgnoreCase(header.getName())) {
                    from = header.getValue();
                }

                if ("Subject".equalsIgnoreCase(header.getName())) {
                    subject = header.getValue();
                }
            }

            emails.add(new EmailDTO(
                    from,
                    subject,
                    fullMessage.getSnippet()
            ));
        }

        return emails;
    }
}