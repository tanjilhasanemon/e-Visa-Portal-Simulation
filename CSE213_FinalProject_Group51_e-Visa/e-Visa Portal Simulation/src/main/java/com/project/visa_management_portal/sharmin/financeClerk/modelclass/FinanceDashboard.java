package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

public class FinanceDashboard {
    private int totalPayments;
    private int pendingVerifications;
    private int refundsProcessed;

    public FinanceDashboard() {
    }

    public FinanceDashboard(int totalPayments, int refundsProcessed, int pendingVerifications) {
        this.totalPayments = totalPayments;
        this.refundsProcessed = refundsProcessed;
        this.pendingVerifications = pendingVerifications;
    }

    public int getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(int totalPayments) {
        this.totalPayments = totalPayments;
    }

    public int getPendingVerifications() {
        return pendingVerifications;
    }

    public void setPendingVerifications(int pendingVerifications) {
        this.pendingVerifications = pendingVerifications;
    }

    public int getRefundsProcessed() {
        return refundsProcessed;
    }

    public void setRefundsProcessed(int refundsProcessed) {
        this.refundsProcessed = refundsProcessed;
    }

    @Override
    public String toString() {
        return "FinanceDashboard{" +
                "totalPayments=" + totalPayments +
                ", pendingVerifications=" + pendingVerifications +
                ", refundsProcessed=" + refundsProcessed +
                '}';
    }
}
