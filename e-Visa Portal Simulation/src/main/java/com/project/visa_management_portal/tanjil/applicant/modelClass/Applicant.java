package com.project.visa_management_portal.tanjil.applicant.modelClass;

import com.project.visa_management_portal.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Applicant user model. Keeps optional applicant-specific fields.
 */
public class Applicant extends User {

    private String passportNumber;
    private final List<String> applicationIds; // simple list of application ids for demo

    public Applicant() {
        super();
        this.applicationIds = new ArrayList<>();
    }

    public Applicant(String name, String email, String password, String passportNumber) {
        super(password, email, name, null);
        this.passportNumber = passportNumber;
        this.applicationIds = new ArrayList<>();
    }

    // applicant-specific getters/setters
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public List<String> getApplicationIds() { return applicationIds; }
    public void addApplicationId(String appId) { this.applicationIds.add(appId); }

    // implement abstract methods simply
    @Override
    protected boolean signOut() {
        // nothing to clean for now
        return true;
    }

    @Override
    protected boolean signIn(String userType, String email, String password) {
        // very simple local check: compare local fields
        return this.email != null && this.email.equalsIgnoreCase(email) && this.password.equals(password);
    }

    @Override
    protected boolean changePassword(String oldPassword, String newPassword) {
        if (this.password != null && this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }
}
