package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

import com.project.visa_management_portal.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Registered Agent user model — has licenseNumber and clients list.
 */
public class RegisteredAgent extends User {

    private String licenseNumber;
    private String agencyName;
    private final List<String> clientIds; // store client userIds

    public RegisteredAgent() {
        super();
        this.clientIds = new ArrayList<>();
    }

    public RegisteredAgent(String name, String email, String password, String licenseNumber) {
        super(password, email, name, null);
        this.licenseNumber = licenseNumber;
        this.clientIds = new ArrayList<>();
    }

    // getters/setters
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public String getAgencyName() { return agencyName; }
    public void setAgencyName(String agencyName) { this.agencyName = agencyName; }

    public List<String> getClientIds() { return clientIds; }
    public void addClientId(String clientId) { this.clientIds.add(clientId); }

    // implement abstract methods
    @Override
    protected boolean signOut() {
        return true;
    }

    @Override
    protected boolean signIn(String userType, String email, String password) {
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
