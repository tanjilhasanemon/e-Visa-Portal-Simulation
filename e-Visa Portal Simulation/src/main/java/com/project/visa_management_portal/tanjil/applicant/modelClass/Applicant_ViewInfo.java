package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A1 - View e-Visa Info
public class Applicant_ViewInfo {
    // fields
    private String infoTextPath;    // path to local info text
    private String imagePath;       // path to local image

    // methods
    public void loadInfo() { /* DP: load text + image from resources */ }
    public String getInfoText() { return infoTextPath; }
    public String getImagePath() { return imagePath; }
}
