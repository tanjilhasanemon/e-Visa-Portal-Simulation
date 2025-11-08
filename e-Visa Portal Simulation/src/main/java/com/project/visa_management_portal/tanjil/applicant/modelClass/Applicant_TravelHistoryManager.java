package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A3 - Add Travel History to an Application
public class Applicant_TravelHistoryManager {
    // fields
    private String applicationId;
    private java.util.List<String> travelRecords; // store simple strings "country|from|to"

    // methods
    public void openTravelHistory(String applicationId) { this.applicationId = applicationId; }
    public boolean addTravelRecord(String country, java.time.LocalDate from, java.time.LocalDate to) {
        if (country == null || from.isAfter(to)) return false;
        travelRecords.add(country + "|" + from.toString() + "|" + to.toString());
        return true;
    }
    public java.util.List<String> listTravelRecords() { return travelRecords; }
}
