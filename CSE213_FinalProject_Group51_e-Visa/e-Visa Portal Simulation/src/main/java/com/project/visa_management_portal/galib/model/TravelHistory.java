package com.project.visa_management_portal.galib.model;

import java.time.LocalDate;
import java.util.UUID;

public class TravelHistory {
    private final String id;
    private final String country;
    private final LocalDate from;
    private final LocalDate to;

    public TravelHistory(String country, LocalDate from, LocalDate to, String notes) {
        this.id = UUID.randomUUID().toString();
        this.country = country;
        this.from = from;
        this.to = to;
    }

    public String getId() { return id; }
    public String getCountry() { return country; }
    public LocalDate getFrom() { return from; }
    public LocalDate getTo() { return to; }
}
