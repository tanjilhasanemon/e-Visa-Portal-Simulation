package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

import java.time.LocalDate;

public class VerifyPayment {
    private Integer applicantID;
    private String name;
    private Double amount;
    private String status;
    private LocalDate date;

    public VerifyPayment() {
    }

    public VerifyPayment(Integer applicantID, String name, Double amount, String status, LocalDate date) {
        this.applicantID = applicantID;
        this.name = name;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    public Integer getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Integer applicantID) {
        this.applicantID = applicantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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