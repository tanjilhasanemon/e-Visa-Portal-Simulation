package com.project.visa_management_portal.tanjil;

public class ApplicationStatus {
    private String applicationId;
    private String status;        // e.g., "Pending", "Fee Paid", "Under Review", "Approved", "Rejected"
    private String remark;


    public ApplicationStatus() {
    }

    public ApplicationStatus(String applicationId, String remark, String status) {
        this.applicationId = applicationId;
        this.remark = remark;
        this.status = status;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "ApplicationStatus{" +
                "applicationId='" + applicationId + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
