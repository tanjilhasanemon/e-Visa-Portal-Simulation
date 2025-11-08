package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R4 - Upload Client Documents
public class Agent_DocumentManager {
    // fields
    private String applicationId;
    private java.util.List<String> documentPaths;

    // methods
    public void openUploader(String applicationId) { this.applicationId = applicationId; }
    public boolean chooseAndAttach(String filepath) { documentPaths.add(filepath); return true; }
    public boolean validateDocuments() { /* check file extensions */ return true; }
}
