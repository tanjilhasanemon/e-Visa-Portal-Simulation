package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R5 - Submit Client Application (final submit)
public class Agent_SubmissionManager {
    // fields
    private String applicationId;

    // methods
    public void openForSubmission(String applicationId) { this.applicationId = applicationId; }
    public boolean validateForSubmit() { /* check required docs/info exist */ return true; }
    public boolean submit() { /* DP: mark submitted */ return true; }
}
