package com.project.visa_management_portal.tanjil;

import java.time.LocalDate;

import java.util.UUID;

public class Payment {
    private String paymentId;
    private String applicationId;
    private int amountBdt;
    private String paymentDate;
    private String status;

    public Payment() {
    }

    public Payment(String applicationId, int amountBdt) {
        this.paymentId = UUID.randomUUID().toString();
        this.applicationId = applicationId;
        this.amountBdt = amountBdt;
        this.paymentDate = LocalDate.now().toString();
        this.status = "Paid";
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public int getAmountBdt() {
        return amountBdt;
    }

    public void setAmountBdt(int amountBdt) {
        this.amountBdt = amountBdt;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", amountBdt=" + amountBdt +
                ", paymentDate='" + paymentDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}




