package com.project.visa_management_portal.tanjil;

import java.io.Serializable;
import java.time.LocalDate;

public class TravelHistory implements Serializable {

    private String country;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String clientOrApplicantID;

    public TravelHistory() {
    }

    public TravelHistory(String country, LocalDate fromDate, LocalDate toDate) {
        this.country = country;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public TravelHistory(String clientOrApplicantID, String country, LocalDate fromDate, LocalDate toDate) {
        this.clientOrApplicantID = clientOrApplicantID;
        this.country = country;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getClientOrApplicantID() {
        return clientOrApplicantID;
    }

    public void setClientOrApplicantID(String clientOrApplicantID) {
        this.clientOrApplicantID = clientOrApplicantID;
    }

    @Override
    public String toString() {
        return "TravelHistory{" +
                "country='" + country + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", clientOrApplicantID='" + clientOrApplicantID + '\'' +
                '}';
    }
}
