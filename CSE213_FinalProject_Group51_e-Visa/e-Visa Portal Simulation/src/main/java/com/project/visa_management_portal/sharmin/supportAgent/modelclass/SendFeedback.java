package com.project.visa_management_portal.sharmin.supportagent.modelclass;

public class SendFeedback {
    private String username;
    private String feedbacktype;

    public SendFeedback() {
    }

    public SendFeedback(String username, String feedbacktype) {
        this.username = username;
        this.feedbacktype = feedbacktype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedbacktype() {
        return feedbacktype;
    }

    public void setFeedbacktype(String feedbacktype) {
        this.feedbacktype = feedbacktype;
    }

    @Override
    public String toString() {
        return "SendFeedback{" +
                "username='" + username + '\'' +
                ", feedbacktype='" + feedbacktype + '\'' +
                '}';
    }
}