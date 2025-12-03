package com.project.visa_management_portal.sharmin.supportagent.modelclass;

public class SendFeedback {
    private String subject;
    private String message;

    public SendFeedback() {
    }

    public SendFeedback(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendFeedback{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
