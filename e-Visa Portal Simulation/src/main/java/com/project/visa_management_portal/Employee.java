package com.project.visa_management_portal;

public class Employee extends User {

    @Override
    protected boolean signOut() {
        return false;
    }

    @Override
    protected boolean signIn(String userType, String email, String password) {
        return false;
    }

    @Override
    protected boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }
}
