package com.sushmitha.smartinboxguardianbackend.controller;

import com.sushmitha.smartinboxguardianbackend.dto.DashboardDTO;
import com.sushmitha.smartinboxguardianbackend.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public List<DashboardDTO> getDashboard() throws Exception {
        return dashboardService.getDashboard();
    }
}