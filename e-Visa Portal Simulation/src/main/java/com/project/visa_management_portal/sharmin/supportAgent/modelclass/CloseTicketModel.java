package com.project.visa_management_portal.sharmin.supportagent.modelclass;

public class CloseTicketModel {
    private int ticketId;

    public CloseTicketModel() {
    }

    public CloseTicketModel(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "CloseTicketModel{" +
                "ticketId=" + ticketId +
                '}';
    }
}