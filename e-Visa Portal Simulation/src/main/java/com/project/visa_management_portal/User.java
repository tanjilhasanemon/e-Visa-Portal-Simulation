package com.project.visa_management_portal;

import java.io.Serializable;
import java.util.UUID;

public abstract class User implements Serializable {


    protected String userId;
    protected String name;
    protected String email;
    protected String password;

    public User(String password, String email, String name, String userId) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.userId = userId;
    }

    public User() {
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    protected void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public void signUpExternal(String name, String email, String password) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // abstract methods that subclasses must implement
    protected abstract boolean signOut();

    protected abstract boolean signIn(String userType, String email, String password);

    protected abstract boolean changePassword(String oldPassword, String newPassword);
}
