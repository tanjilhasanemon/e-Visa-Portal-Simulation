package com.project.visa_management_portal.tanjil.applicant.modelClass;


/*
 Suggested methods:
 // public boolean validateAmount(double required);
*/

public class Payment {
    public String paymentId;
    public String applicationId;
    public String payerId;
    public double amount;
    public String paidDate;
    public String status;   // "PENDING","PAID","VERIFIED"
    public String receiptPath;
}
