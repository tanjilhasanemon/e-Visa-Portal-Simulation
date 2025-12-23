package com.project.visa_management_portal;

import java.io.Serial;
import java.io.Serializable;


public class ExternalUser extends User implements Serializable {


    private String userType;      // "Applicant" or "Registered Agent"
    private String agentLicenseNo; // optional for agents

    public ExternalUser() {
        super();
    }

    public ExternalUser(String userType, String name, String email, String password, String agentLicenseNo) {
        super(password, email, name, null);
        this.userType = userType;
        this.agentLicenseNo = agentLicenseNo;
        // if you want to auto-generate id here, call signUpExternal afterwards
    }

    // getters / setters
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getAgentLicenseNo() { return agentLicenseNo; }
    public void setAgentLicenseNo(String agentLicenseNo) { this.agentLicenseNo = agentLicenseNo; }

    @Override
    protected boolean signOut() {
        return true;
    }

    @Override
    protected boolean signIn(String userType, String email, String password) {
        if (email == null || password == null) return false;
        if (this.email == null || this.password == null) return false;
        boolean sameEmail = this.email.equalsIgnoreCase(email.trim());
        boolean samePass = this.password.equals(password);
        boolean sameRole = userType == null || this.userType == null || userType.equals(this.userType);
        return sameEmail && samePass && sameRole;
    }

    @Override
    protected boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword == null || newPassword == null) return false;
        if (!oldPassword.equals(this.password)) return false;
        this.password = newPassword;
        return true;
    }

    @Override
    public String toString() {
        return "ExternalUser{" +
                "userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", agentLicenseNo='" + agentLicenseNo + '\'' +
                '}';
    }
}
