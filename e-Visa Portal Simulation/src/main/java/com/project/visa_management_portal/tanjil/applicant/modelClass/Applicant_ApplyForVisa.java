package com.project.visa_management_portal.tanjil.applicant.modelClass;

// A2 - Apply for Visa (create & submit)
public class Applicant_ApplyForVisa {
    // fields
    private String currentApplicationId; // id of the in-progress application
    private String applicantId;          // who is applying

    // form fields (kept simple)
    private VisaType visaType;
    private String nationality;
    private String motherLanguage;
    private String passportNumber;
    private ContactInfo contact;

    // methods
    public String openForm(String applicantId) { this.applicantId = applicantId; /* create ID */ return currentApplicationId; }
    public boolean validateForm() { /* VL: check non-empty fields */ return true; }
    public boolean submitForm() { /* DP: mark Submitted, persist (in-memory) */ return true; }
}
