package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R7 - Download Client Documents
public class Agent_DownloadManager {
    // fields
    private String agentId;
    private java.util.Map<String, String> docMap; // documentId -> path

    // methods
    public java.util.List<String> listClientDocs(String applicationId) {
        // return subset keys (simplified)
        return new java.util.ArrayList<>(docMap.values());
    }
    public String downloadDoc(String documentId) { return docMap.get(documentId); }
}
