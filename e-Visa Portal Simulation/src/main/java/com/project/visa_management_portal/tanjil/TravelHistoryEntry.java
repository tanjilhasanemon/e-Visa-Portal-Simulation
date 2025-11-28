package com.project.visa_management_portal.tanjil;

import java.time.LocalDate;

public class TravelHistoryEntry {

    private String country;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String applicantId;   // present when applicant adds
    private String applicationId;


    public TravelHistoryEntry() {
    }

    public TravelHistoryEntry(String applicationId, String applicantId, LocalDate toDate, LocalDate fromDate, String country) {
        this.applicationId = applicationId;
        this.applicantId = applicantId;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.country = country;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }


    @Override
    public String toString() {
        return "TravelHIstoryEntry{" +
                "country='" + country + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", applicantId='" + applicantId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                '}';
    }




}
