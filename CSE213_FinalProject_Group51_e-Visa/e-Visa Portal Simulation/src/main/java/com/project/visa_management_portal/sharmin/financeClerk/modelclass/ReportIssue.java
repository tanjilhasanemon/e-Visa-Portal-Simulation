package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

public class ReportIssue {
    private String subject,issueType;

    public ReportIssue() {
    }

    public ReportIssue(String subject, String issueType) {
        this.subject = subject;
        this.issueType = issueType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    @Override
    public String toString() {
        return "ReportIssue{" +
                "subject='" + subject + '\'' +
                ", issueType='" + issueType + '\'' +
                '}';
    }
}