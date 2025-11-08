package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A6 - Track Application
public class Applicant_Tracker {
    // fields
    private String applicantId;
    private java.util.List<String> applicationSummaries; // simple list: "appId|status"

    // methods
    public void openTracker(String applicantId) { this.applicantId = applicantId; }
    public java.util.List<String> listApplications() { return applicationSummaries; }
    public String viewApplicationDetail(String applicationId) { return "detail for " + applicationId; }
}
