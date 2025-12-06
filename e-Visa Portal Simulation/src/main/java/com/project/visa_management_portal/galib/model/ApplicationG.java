package com.project.visa_management_portal.galib.model;

public class ApplicationG {
    public String appId;
    public String applicantName;
    public String passportNo;
    public boolean passportVerified;
    public String passportNote;

    public ApplicationG(String appId, String applicantName, String passportNo, boolean passportVerified, String passportNote) {
        this.appId = appId;
        this.applicantName = applicantName;
        this.passportNo = passportNo;
        this.passportVerified = passportVerified;
        this.passportNote = passportNote;
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

    @Override
    public String toString() {
        return "ApplicationG{" +
                "appId='" + appId + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", passport=" + passportNo +
                ", passportVerified=" + passportVerified +
                ", passportNote='" + passportNote + '\'' +
                '}';
    }
}
