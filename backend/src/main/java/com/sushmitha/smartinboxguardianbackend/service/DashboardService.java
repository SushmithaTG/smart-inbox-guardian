package com.sushmitha.smartinboxguardianbackend.service;

import com.sushmitha.smartinboxguardianbackend.dto.DashboardDTO;
import com.sushmitha.smartinboxguardianbackend.dto.EmailDTO;
import com.sushmitha.smartinboxguardianbackend.gmail.GmailReader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final GmailReader gmailReader;

    public DashboardService(GmailReader gmailReader) {
        this.gmailReader = gmailReader;
    }

    public List<DashboardDTO> getDashboard() throws Exception {

        List<EmailDTO> emails = gmailReader.getMessages(50L);

        Map<String, Long> counts = new HashMap<>();

        for (EmailDTO email : emails) {

            String category = email.getCategory().name();

            counts.put(category,
                    counts.getOrDefault(category, 0L) + 1);
        }

        List<DashboardDTO> dashboard = new ArrayList<>();

        for (Map.Entry<String, Long> entry : counts.entrySet()) {

            dashboard.add(
                    new DashboardDTO(
                            entry.getKey(),
                            entry.getValue()
                    )
            );
        }

        return dashboard;
    }
}