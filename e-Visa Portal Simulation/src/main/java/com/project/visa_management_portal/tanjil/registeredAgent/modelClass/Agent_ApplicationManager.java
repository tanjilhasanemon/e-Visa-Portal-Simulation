package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R2 - Prepare & Submit Application for a Client (no draft)
public class Agent_ApplicationManager {
    // fields
    private String agentId;
    private java.util.List<String> preparedAppIds;

    // methods
    public String openApplicationForClient(String clientId) {
        String appId = "A-" + System.currentTimeMillis();
        preparedAppIds.add(appId);
        return appId;
    }
    public boolean validateApplication(String appId, VisaType visaType, String nationality, String motherLanguage, String passport) {
        return visaType != null && passport != null && !passport.isEmpty();
    }
    public boolean submitApplication(String appId, String createdByAgentId) {
        // DP: mark submitted & record who created
        return true;
    }
}
