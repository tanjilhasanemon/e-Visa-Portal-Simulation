package com.project.visa_management_portal.tanjil.applicant.modelClass;


import com.project.visa_management_portal.common.User;

import java.time.LocalDate;

/*
 Suggested methods:
 // public void applyForVisa(NewVisaApplication form);
 // public void uploadDocument(String applicationId, Application.Document doc);
 // public String makePayment(String applicationId, Payment p);
 // public Application[] listMyApplications();
*/

public class Applicant extends User {
    public String passportNumber;
    public String address;
    public LocalDate dateOfBirth;



}
