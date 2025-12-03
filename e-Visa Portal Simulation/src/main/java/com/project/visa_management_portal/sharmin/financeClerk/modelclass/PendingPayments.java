package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

public class PendingPayments {
    private int paymentId;
    private String applicantName;
    private double amount;
    private String status;

    public PendingPayments() {
    }

    public PendingPayments(int paymentId, String applicantName, double amount, String status) {
        this.paymentId = paymentId;
        this.applicantName = applicantName;
        this.amount = amount;
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PendingPayments{" +
                "paymentId=" + paymentId +
                ", applicantName='" + applicantName + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
