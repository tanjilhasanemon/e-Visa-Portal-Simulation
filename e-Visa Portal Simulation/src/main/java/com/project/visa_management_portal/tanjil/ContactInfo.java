package com.project.visa_management_portal.tanjil;

// Shared simple types
public class ContactInfo {
    public String phone;
    public String address;
    public String email;
}

public enum VisaType { TOURIST, BUSINESS, TRANSIT, WORK }
public enum DocumentType { PASSPORT, PHOTO, OTHER }
public enum ApplicationStatus { SUBMITTED, UNDER_REVIEW, APPROVED, REJECTED, ISSUED, CANCELLED }
public enum PaymentStatus { PENDING, PAID, VERIFIED, FLAGGED, REFUNDED }
