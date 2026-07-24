package com.sushmitha.smartinboxguardianbackend.util;

import com.sushmitha.smartinboxguardianbackend.enums.EmailPriority;

public class EmailPriorityDetector {

    public static EmailPriority detect(String from,
                                       String subject,
                                       String snippet) {

        String text = (from + " " + subject + " " + snippet).toLowerCase();

        // High Priority
        if (text.contains("otp")
                || text.contains("verification")
                || text.contains("security alert")
                || text.contains("interview")
                || text.contains("urgent")
                || text.contains("invoice")
                || text.contains("payment due")) {

            return EmailPriority.HIGH;
        }

        // Medium Priority
        if (text.contains("linkedin")
                || text.contains("github")
                || text.contains("glassdoor")
                || text.contains("naukri")
                || text.contains("job")) {

            return EmailPriority.MEDIUM;
        }

        // Everything else
        return EmailPriority.LOW;
    }
}