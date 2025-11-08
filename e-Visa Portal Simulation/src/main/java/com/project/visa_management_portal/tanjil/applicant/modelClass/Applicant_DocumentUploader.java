package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A4 - Upload Documents (passport, photo)
public class Applicant_DocumentUploader {
    // fields
    private String applicationId;
    private java.util.List<String> attachedFilePaths; // file paths

    // methods
    public void openUploader(String applicationId) { this.applicationId = applicationId; }
    public boolean chooseFile(String filepath) { attachedFilePaths.add(filepath); return true; } // UI file chooser supplies filepath
    public boolean validateFiles() { /* check extensions */ return true; }
    public boolean attachFiles() { /* DP: save references to application */ return true; }
}
