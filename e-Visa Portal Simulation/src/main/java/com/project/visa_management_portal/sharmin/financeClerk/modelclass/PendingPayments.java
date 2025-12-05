package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

import java.time.LocalDate;

public class PendingPayments {
    private int transactionId;
    private String applicantName;
    private int amount;
    private String status;
    private String paymentMethod;
    private LocalDate paymentDate;

    public PendingPayments() {
    }

    public PendingPayments(int transactionId, String applicantName, int amount, String status, String paymentMethod, LocalDate paymentDate) {
        this.transactionId = transactionId;
        this.applicantName = applicantName;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PendingPayments{" +
                "transactionId=" + transactionId +
                ", applicantName='" + applicantName + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }
}