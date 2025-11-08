package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R6 - Track Clients' Applications (view & filter)
public class Agent_TrackingManager {
    // fields
    private String agentId;
    private java.util.List<String> agentApplications; // "appId|clientId|status"

    // methods
    public void openTracker(String agentId) { this.agentId = agentId; }
    public java.util.List<String> listApplications() { return agentApplications; }
    public java.util.List<String> filterApplications(String criteria) {
        // simple filter: return items that contain criteria
        java.util.List<String> out = new java.util.ArrayList<>();
        for (String s : agentApplications) if (s.contains(criteria)) out.add(s);
        return out;
    }
}
