package com.project.visa_management_portal.rifat.operationManager.modelClass;

import java.io.Serializable;
import java.time.LocalDate;

public class ApplicationsRifat implements Serializable {
    public String appId;
    public String visaType;
    public LocalDate submittedAt;
    public String status;
    public String days_pending;
    public String assignedOfficer;
    public LocalDate decisionDate;
    public String flagReason;
    public LocalDate resubmissionFlaggedDate;
    public int pendingResubmittedDays;
    public String setResubmissionTargetDays;
    public String managementRemarks;
    public LocalDate fromDate;
    public LocalDate toDate;


    public ApplicationsRifat(String appId, String visaType, LocalDate submittedAt, String status) {
        this.appId = appId;
        this.visaType = visaType;
        this.submittedAt = submittedAt;
        this.status = status;
    }

    // View status applications
    public ApplicationsRifat(String appId, String visaType, LocalDate submittedAt, String assignedOfficer, String status) {
        this.appId = appId;
        this.visaType = visaType;
        this.submittedAt = submittedAt;
        this.assignedOfficer = assignedOfficer;
        this.status = status;
    }
//    // Flagged reasons
//    public ApplicationsRifat(String appId,String visaType, String flagReason) {
//        this.appId = appId;
//        this.visaType = visaType;
//        this.flagReason = flagReason;
//    }
    //Overdue Applications
    public ApplicationsRifat(String appId, LocalDate submittedAt, String days_pending, String assignedOfficer, String status) {
        this.appId = appId;
        this.submittedAt = submittedAt;
        this.days_pending = days_pending;
        this.assignedOfficer = assignedOfficer;
        this.status = status;
    }

    // Resubmission flagged applications
    public ApplicationsRifat(String appId, String assignedOfficer, String flagReason, String managementRemarks,LocalDate resubmissionFlaggedDate , String setResubmissionTargetDays) {
        this.appId = appId;
        this.assignedOfficer = assignedOfficer;
        this.flagReason = flagReason;
        this.managementRemarks = managementRemarks;
        this.resubmissionFlaggedDate = resubmissionFlaggedDate;
        this.setResubmissionTargetDays = setResubmissionTargetDays;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public LocalDate getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDate submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDays_pending() {
        return days_pending;
    }

    public void setDays_pending(String days_pending) {
        this.days_pending = days_pending;
    }

    public String getAssignedOfficer() {
        return assignedOfficer;
    }

    public void setAssignedOfficer(String assignedOfficer) {
        this.assignedOfficer = assignedOfficer;
    }

    public LocalDate getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(LocalDate decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getFlagReason() {
        return flagReason;
    }

    public void setFlagReason(String flagReason) {
        this.flagReason = flagReason;
    }

    public LocalDate getResubmissionFlaggedDate() {
        return resubmissionFlaggedDate;
    }

    public void setResubmissionFlaggedDate(LocalDate resubmissionFlaggedDate) {
        this.resubmissionFlaggedDate = resubmissionFlaggedDate;
    }

    public int getPendingResubmittedDays() {
        return pendingResubmittedDays;
    }

    public void setPendingResubmittedDays(int pendingResubmittedDays) {
        this.pendingResubmittedDays = pendingResubmittedDays;
    }

    public String getSetResubmissionTargetDays() {
        return setResubmissionTargetDays;
    }

    public void setSetResubmissionTargetDays(String setResubmissionTargetDays) {
        this.setResubmissionTargetDays = setResubmissionTargetDays;
    }

    public String getManagementRemarks() {
        return managementRemarks;
    }

    public void setManagementRemarks(String managementRemarks) {
        this.managementRemarks = managementRemarks;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Object getColAppID() {
        return appId;
    }

    public void setResubmissionTargetDays(String target) {
        this.setResubmissionTargetDays = target;
    }

    public void setManagerNoteForResubmission(String managerNote) {
        this.managementRemarks = managerNote;
    }

    public void setManagerNote(String managerNote) {
        this.managementRemarks = managerNote;
    }

    public void setTargetValue(int targetValue) {
        this.setResubmissionTargetDays = String.valueOf(targetValue);
    }
}




