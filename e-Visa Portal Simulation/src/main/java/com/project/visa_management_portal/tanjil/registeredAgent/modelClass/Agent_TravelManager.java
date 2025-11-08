package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

// R3 - Add Travel History to Application
public class Agent_TravelManager {
    // fields
    private String applicationId;
    private java.util.List<String> travelRecords; // "country|from|to"

    // methods
    public void openTravel(String applicationId) { this.applicationId = applicationId; }
    public boolean addTravel(String country, java.time.LocalDate from, java.time.LocalDate to) {
        if (country == null || from.isAfter(to)) return false;
        travelRecords.add(country + "|" + from + "|" + to);
        return true;
    }
    public java.util.List<String> listTravel() { return travelRecords; }
}
