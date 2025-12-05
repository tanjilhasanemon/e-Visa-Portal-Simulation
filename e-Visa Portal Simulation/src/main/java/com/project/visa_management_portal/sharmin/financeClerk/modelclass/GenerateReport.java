package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

import java.time.LocalDate;

public class GenerateReport {
    private int transactionId;
    private String applicantName;
    private int amount;
    private String status;
    private LocalDate paymentDate;
    private String paymentMethod;

    public GenerateReport() {
    }

    public GenerateReport(int transactionId, String applicantName, int amount, String status, LocalDate paymentDate, String paymentMethod) {
        this.transactionId = transactionId;
        this.applicantName = applicantName;
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "GenerateReport{" +
                "transactionId=" + transactionId +
                ", applicantName='" + applicantName + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}