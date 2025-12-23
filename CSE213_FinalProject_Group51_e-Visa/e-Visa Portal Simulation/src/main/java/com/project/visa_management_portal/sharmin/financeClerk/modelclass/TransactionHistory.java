package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

import java.time.LocalDate;

public class TransactionHistory {
    private int transactionId;
    private String applicantName;
    private String status;
    private int amount;
    private LocalDate paymentDate;
    private String paymentMethod;

    public TransactionHistory() {

    }

    public TransactionHistory(int transactionId, String applicantName, String status, int amount, LocalDate paymentDate, String paymentMethod) {
        this.transactionId = transactionId;
        this.applicantName = applicantName;
        this.status = status;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transactionId=" + transactionId +
                ", applicantName='" + applicantName + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}