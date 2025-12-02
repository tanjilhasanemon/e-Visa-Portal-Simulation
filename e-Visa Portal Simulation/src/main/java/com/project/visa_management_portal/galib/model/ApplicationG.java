package com.project.visa_management_portal.galib.model;

import java.time.LocalDate;

public class ApplicationG {
    public String appId;
    public String applicantName;
    public String visaType;
    public String passportNo;
    public boolean passportVerified;
    public String passportNote;
    public LocalDate submittedAt;
    public String status;

    public ApplicationG(String appId, String applicantName, String visaType, String passportNo, boolean passportVerified, String passportNote, LocalDate submittedAt, String status) {
        this.appId = appId;
        this.applicantName = applicantName;
        this.passportNo = passportNo;
        this.visaType = visaType;
        this.passportVerified = passportVerified;
        this.passportNote = passportNote;
        this.submittedAt = submittedAt;
        this.status = status;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public boolean isPassportVerified() {
        return passportVerified;
    }

    public void setPassportVerified(boolean passportVerified) {
        this.passportVerified = passportVerified;
    }

    public String getPassportNote() {
        return passportNote;
    }

    public void setPassportNote(String passportNote) {
        this.passportNote = passportNote;
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

    @Override
    public String toString() {
        return "ApplicationG{" +
                "appId='" + appId + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", visaType='" + visaType + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", passportVerified=" + passportVerified +
                ", passportNote='" + passportNote + '\'' +
                ", submittedAt=" + submittedAt +
                ", status='" + status + '\'' +
                '}';
    }
}
