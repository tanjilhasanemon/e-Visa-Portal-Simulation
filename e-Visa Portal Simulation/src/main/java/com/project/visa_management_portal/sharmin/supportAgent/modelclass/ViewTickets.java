package com.project.visa_management_portal.sharmin.supportagent.modelclass;

import java.time.LocalDate;

public class ViewTickets {
    private int ticketId;
    private String userName;
    private String issueType;
    private String status;
    private LocalDate date;

    public ViewTickets() {
    }

    public ViewTickets(int ticketId, String userName, String issueType, String status, LocalDate date) {
        this.ticketId = ticketId;
        this.userName = userName;
        this.issueType = issueType;
        this.status = status;
        this.date = date;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ViewTickets{" +
                "ticketId=" + ticketId +
                ", userName='" + userName + '\'' +
                ", issueType='" + issueType + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
