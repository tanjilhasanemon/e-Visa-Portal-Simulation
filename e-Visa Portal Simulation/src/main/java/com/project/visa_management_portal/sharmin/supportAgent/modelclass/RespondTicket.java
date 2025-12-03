package com.project.visa_management_portal.sharmin.supportagent.modelclass;

public class RespondTicket {
    private int ticketId;
    private String replyMessage;

    public RespondTicket() {
    }

    public RespondTicket(int ticketId, String replyMessage) {
        this.ticketId = ticketId;
        this.replyMessage = replyMessage;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    @Override
    public String toString() {
        return "RespondTicket{" +
                "ticketId=" + ticketId +
                ", replyMessage='" + replyMessage + '\'' +
                '}';
    }
}
