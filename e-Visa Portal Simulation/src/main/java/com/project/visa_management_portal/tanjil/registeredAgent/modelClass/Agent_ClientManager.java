package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R1 - Create Client Profile
public class Agent_ClientManager {
    // fields
    private String agentId;
    private java.util.List<String> clientIds; // simple list of client IDs
    // optionally store basic client info map
    private java.util.Map<String, String> clientBasicInfo; // clientId -> "name|passport|contact"

    // methods
    public void openClientManager(String agentId) { this.agentId = agentId; }
    public String createClient(String name, String passport, String contact) {
        String clientId = "C-" + System.currentTimeMillis();
        clientIds.add(clientId);
        clientBasicInfo.put(clientId, name + "|" + passport + "|" + contact);
        return clientId;
    }
    public String getClientInfo(String clientId) { return clientBasicInfo.get(clientId); }
}
