package com.sushmitha.smartinboxguardianbackend.gmail;

import com.google.api.services.gmail.GmailScopes;
import java.util.List;

public class GmailConstants {

    public static final String APPLICATION_NAME = "Smart Inbox Guardian";

    public static final List<String> SCOPES =
            List.of(GmailScopes.GMAIL_READONLY);

    public static final String TOKENS_DIRECTORY_PATH = "tokens";

    public static final String CREDENTIALS_FILE_PATH =
            "/credentials.json";
}