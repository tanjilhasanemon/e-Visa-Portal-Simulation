package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;


/*
 Suggested methods:
 // public void submitReview(String applicationId, String comment, String decision);
*/

public class ApplicationReview {
    public String reviewId;
    public String applicationId;
    public String agentId;
    public String comment;
    public String reviewDate;
    public String decision;   // "APPROVE","REJECT","PENDING"
}
