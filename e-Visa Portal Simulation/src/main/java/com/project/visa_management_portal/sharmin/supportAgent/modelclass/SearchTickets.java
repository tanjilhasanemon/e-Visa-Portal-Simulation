package com.project.visa_management_portal.sharmin.supportagent.modelclass;

import java.time.LocalDate;

public class SearchTickets {
    private String name;
    private int ticketId;
    private LocalDate date;

    public SearchTickets() {
    }

    public SearchTickets(String name, int ticketId, LocalDate date) {
        this.name = name;
        this.ticketId = ticketId;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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
                "name='" + name + '\'' +
                ", ticketId=" + ticketId +
                ", date=" + date +
                '}';
    }
}
