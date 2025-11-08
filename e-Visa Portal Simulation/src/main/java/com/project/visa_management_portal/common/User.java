package com.project.visa_management_portal.common;

import java.time.LocalDateTime;

/*
 Suggested methods (implement later in model or controller):
 // public void login(String password);
 // public void logout();
 // public void changePassword(String oldPwd, String newPwd);
 // public void updateProfile(...);
*/

public class User {
    public int userId;
    public String fullName, email;
    public String password;
    public int phoneNumber;
    public String role;            // "APPLICANT" or "AGENT"
}
