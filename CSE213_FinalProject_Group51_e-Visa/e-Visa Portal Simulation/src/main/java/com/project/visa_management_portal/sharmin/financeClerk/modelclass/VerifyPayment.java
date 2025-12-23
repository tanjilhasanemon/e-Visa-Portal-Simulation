package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

import java.time.LocalDate;

public class VerifyPayment {
    private int applicantID;
    private String name;
    private int amount;
    private String status;
    private LocalDate date;

    public VerifyPayment() {
    }

    public VerifyPayment(int applicantID, String name, int amount, String status, LocalDate date) {
        this.applicantID = applicantID;
        this.name = name;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
        return "VerifyPayment{" +
                "applicantID=" + applicantID +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}