package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

public class ReportIssue {
    private String subject;
    private String message;
    private String status;

    public ReportIssue() {
    }

    public ReportIssue(String subject, String message, String status) {
        this.subject = subject;
        this.message = message;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReportIssue{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
