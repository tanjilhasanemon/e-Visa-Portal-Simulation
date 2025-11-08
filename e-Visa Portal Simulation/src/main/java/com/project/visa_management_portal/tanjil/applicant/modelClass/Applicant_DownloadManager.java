package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A7 - Download Documents
public class Applicant_DownloadManager {
    // fields
    private String applicantId;
    private java.util.List<String> availableFiles; // paths

    // methods
    public java.util.List<String> listAvailableFiles(String applicantId) { this.applicantId = applicantId; return availableFiles; }
    public String downloadFile(String filePath) { /* DP: return path or local copy */ return filePath; }
}
