package com.project.visa_management_portal.commonModelClasses;

import java.util.Date;

public class Payment {
    private String paymentId;
    private String userId;
    private double amount;
    private String method; // Card / Bank / Mobile
    private Date paymentDate;
    private String status; // Paid / Pending / Failed

    // Methods: makePayment(), viewPaymentDetails(), verifyPayment()
}
