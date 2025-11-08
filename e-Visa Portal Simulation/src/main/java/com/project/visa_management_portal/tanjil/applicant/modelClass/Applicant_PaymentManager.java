package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A5 - Pay Fee (simple exact-amount)
public class Applicant_PaymentManager {
    // fields
    private String applicationId;
    private java.math.BigDecimal requiredAmount;
    private java.util.List<String> receipts; // simple receipt ids

    // methods
    public void openPayment(String applicationId, java.math.BigDecimal requiredAmount) {
        this.applicationId = applicationId; this.requiredAmount = requiredAmount;
    }
    public boolean validateAmount(java.math.BigDecimal entered) { return entered != null; }
    public boolean processPayment(java.math.BigDecimal entered) {
        if (entered.compareTo(requiredAmount) != 0) return false;
        receipts.add("R-" + System.currentTimeMillis());
        return true;
    }
    public java.util.List<String> listReceipts() { return receipts; }
}
