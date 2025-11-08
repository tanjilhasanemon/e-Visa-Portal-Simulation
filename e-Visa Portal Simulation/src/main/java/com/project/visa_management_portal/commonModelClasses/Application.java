package com.project.visa_management_portal.commonModelClasses;

import java.util.Date;

public class Application {
    private String applicationId;
    private String applicantId;
    private String visaType;
    private String status; // Submitted, Under Review, Approved, Rejected
    private Date submissionDate;
    private Date decisionDate;
    private String remarks;

    // Methods: createApplication(), updateStatus(), getApplicationDetails()
}
