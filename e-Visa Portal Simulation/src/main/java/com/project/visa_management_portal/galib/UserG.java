package com.project.visa_management_portal.galib;

import java.time.Instant;
import java.util.Objects;


public abstract class UserG {
    protected String id = "";
    protected String name;
    protected String email;
    protected String phone;
    protected final Instant createdAt;

    protected String passwordHash;

    public UserG(String name, String email, String phone, String passwordPlain) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = Instant.now();
        this.passwordHash = simpleHash(passwordPlain);
    }

    protected String simpleHash(String plain) {
        return Integer.toHexString(Objects.hash(plain));
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Instant getCreatedAt() { return createdAt; }

    public boolean authenticate(String passwordPlain) {
        return simpleHash(passwordPlain).equals(this.passwordHash);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}
