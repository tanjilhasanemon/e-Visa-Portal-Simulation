package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

public class IssueRefund {
    private int applicationId;
    private double refundAmount;
    private String reason;

    public IssueRefund() {

    }

    public IssueRefund(int applicationId, double refundAmount, String reason) {
        this.applicationId = applicationId;
        this.refundAmount = refundAmount;
        this.reason = reason;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "IssueRefund{" +
                "applicationId=" + applicationId +
                ", refundAmount=" + refundAmount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
