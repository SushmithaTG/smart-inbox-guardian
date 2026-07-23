package com.sushmitha.smartinboxguardianbackend.util;

import com.sushmitha.smartinboxguardianbackend.enums.EmailCategory;

public class EmailCategorizer {

    public static EmailCategory categorize(String from) {

        String sender = from.toLowerCase();

        if (sender.contains("linkedin")) {
            return EmailCategory.SOCIAL;
        }

        if (sender.contains("github")) {
            return EmailCategory.DEVELOPER;
        }

        if (sender.contains("amazon")) {
            return EmailCategory.SHOPPING;
        }

        if (sender.contains("glassdoor")
                || sender.contains("naukri")
                || sender.contains("indeed")) {
            return EmailCategory.JOBS;
        }

        if (sender.contains("bank")
                || sender.contains("hdfc")
                || sender.contains("icici")
                || sender.contains("sbi")) {
            return EmailCategory.FINANCE;
        }

        return EmailCategory.OTHERS;
    }
}