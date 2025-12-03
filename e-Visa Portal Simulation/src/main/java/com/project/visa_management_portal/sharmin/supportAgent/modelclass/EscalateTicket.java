package com.project.visa_management_portal.sharmin.supportagent.modelclass;

public class EscalateTicket {
    private int ticketId;
    private String status;

    public EscalateTicket() {
    }

    public EscalateTicket(int ticketId, String status) {
        this.ticketId = ticketId;
        this.status = status;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EscalateTicket{" +
                "ticketId=" + ticketId +
                ", status='" + status + '\'' +
                '}';
    }
}
