package com.project.visa_management_portal.sharmin.supportagent.modelclass;

public class SupportDashboard {
    private int totalTickets;
    private int pendingTickets;
    private int resolvedTickets;

    public SupportDashboard() {
    }

    public SupportDashboard(int totalTickets, int pendingTickets, int resolvedTickets) {
        this.totalTickets = totalTickets;
        this.pendingTickets = pendingTickets;
        this.resolvedTickets = resolvedTickets;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getPendingTickets() {
        return pendingTickets;
    }

    public void setPendingTickets(int pendingTickets) {
        this.pendingTickets = pendingTickets;
    }

    public int getResolvedTickets() {
        return resolvedTickets;
    }

    public void setResolvedTickets(int resolvedTickets) {
        this.resolvedTickets = resolvedTickets;
    }

    @Override
    public String toString() {
        return "SupportDashboard{" +
                "totalTickets=" + totalTickets +
                ", pendingTickets=" + pendingTickets +
                ", resolvedTickets=" + resolvedTickets +
                '}';
    }
}
