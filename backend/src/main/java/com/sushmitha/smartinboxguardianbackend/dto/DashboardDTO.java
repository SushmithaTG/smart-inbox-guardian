package com.sushmitha.smartinboxguardianbackend.dto;

public class DashboardDTO {

    private String category;
    private long count;

    public DashboardDTO() {
    }

    public DashboardDTO(String category, long count) {
        this.category = category;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}