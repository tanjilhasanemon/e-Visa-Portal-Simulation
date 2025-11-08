package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A8 - Help & Feedback
public class Applicant_FeedbackManager {
    // fields
    private String applicantId;
    private java.util.List<String> feedbackStore; // simple store of messages

    // methods
    public void openFeedback(String applicantId) { this.applicantId = applicantId; }
    public boolean submitFeedback(String message) {
        if (message == null || message.isEmpty()) return false;
        feedbackStore.add(applicantId + "|" + message);
        return true;
    }
    public java.util.List<String> listFeedback() { return feedbackStore; }
}
