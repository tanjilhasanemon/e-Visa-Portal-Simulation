package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

import java.time.LocalDate;

public class IssueRefund {
    private int transactionId;
    private String applicantName;
    private int amount;
    private String status;
    private String paymentMethod;
    private LocalDate paymentDate;

    public IssueRefund() {

    }

    public IssueRefund(int transactionId, String applicantName, String status, int amount, String paymentMethod, LocalDate paymentDate) {
        this.transactionId = transactionId;
        this.applicantName = applicantName;
        this.status = status;
        this.amount = amount;
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
        return "IssueRefund{" +
                "transactionId=" + transactionId +
                ", applicantName='" + applicantName + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }
}