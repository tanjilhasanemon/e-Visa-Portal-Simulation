package com.project.visa_management_portal.sharmin.supportagent.modelclass;

import java.time.LocalDate;

public class GenerateSupportReport {
    private String reportType;
    private LocalDate startDate;
    private LocalDate endDate;

    public GenerateSupportReport() {
    }

    public GenerateSupportReport(String reportType, LocalDate startDate, LocalDate endDate) {
        this.reportType = reportType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "GenerateSupportReport{" +
                "reportType='" + reportType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
