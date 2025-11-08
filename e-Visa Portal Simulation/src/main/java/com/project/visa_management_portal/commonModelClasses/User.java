package com.project.visa_management_portal.commonModelClasses;


public abstract class User {
    protected String userId;
    protected String fullName;
    protected String email;
    protected String password;
    protected String phone;
    protected String address;
    protected String nationality;
    protected String userType; // Applicant / Agent

    // --- Methods (to be implemented by subclasses) ---
    public abstract void login();
    public abstract void logout();
    public abstract void editProfile();
}
