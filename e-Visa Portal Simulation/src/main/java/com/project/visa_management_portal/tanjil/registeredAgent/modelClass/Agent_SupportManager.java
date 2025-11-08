package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R8 - Agent Support (submit support request for client)
public class Agent_SupportManager {
    // fields
    private String agentId;
    private java.util.List<String> tickets; // simple ticket IDs

    // methods
    public String openSupport(String agentId) { this.agentId = agentId; return agentId; }
    public String submitSupport(String clientId, String subject, String message) {
        String ticketId = "T-" + System.currentTimeMillis();
        tickets.add(ticketId + "|" + clientId + "|" + subject);
        return ticketId;
    }
    public java.util.List<String> listTickets() { return tickets; }
}
