package com.project.visa_management_portal.sharmin.supportagent.modelclass;

import java.time.LocalDate;

public class SearchTickets {
    private int ticketId;
    private String name, status;
    private LocalDate date;

    public SearchTickets() {
    }

    public SearchTickets(int ticketId, String name, String status, LocalDate date) {
        this.ticketId = ticketId;
        this.name = name;
        this.status = status;
        this.date = date;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "SearchTickets{" +
                "ticketId=" + ticketId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}