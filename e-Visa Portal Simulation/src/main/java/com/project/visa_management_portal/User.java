package com.project.visa_management_portal;

import java.io.Serializable;
import java.util.UUID;

/**
 * Base abstract User class.
 * Provides a concrete signUpExternal that sets fields and returns generated userId.
 */
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

    // --- getters / setters ---
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

    /**
     * Populate this User instance with signup data and generate an id.
     * Returns the generated userId.
     * Note: real apps should hash passwords and persist to DB.
     */
    public String signUpExternal(String name, String email, String password) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password; // for demo only: store plain; hash in real app
        return this.userId;
    }

    // abstract methods that subclasses must implement
    protected abstract boolean signOut();

    protected abstract boolean signIn(String userType, String email, String password);

    protected abstract boolean changePassword(String oldPassword, String newPassword);
}
