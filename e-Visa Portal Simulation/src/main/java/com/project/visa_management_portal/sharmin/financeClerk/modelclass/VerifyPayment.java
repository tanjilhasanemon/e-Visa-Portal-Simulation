package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

public class VerifyPayment {
    private int applicantId;
    private String paymentStatus;
    private double amount;

    public VerifyPayment() {
    }

    public VerifyPayment(int applicantId, String paymentStatus, double amount) {
        this.applicantId = applicantId;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "VerifyPayment{" +
                "applicantId=" + applicantId +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", amount=" + amount +
                '}';
    }
}
