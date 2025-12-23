package com.project.visa_management_portal.tanjil;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class VisaApplication implements Serializable {
    private String applicationId;
    private String fullName;
    private String passportNo;
    private String nationality;
    private String motherLanguage;
    private String gender;
    private String visaType;
    private String purposeOfVisit;
    private String submissionDate;
    private String status;
    private String applicantEmail;
    private String agentEmail;
    private String clientId;
    private int applicationFee;
    private String requiredAction;


    private Random rand = new Random();

    public VisaApplication() {
    }

    // Constructor for Applicant (Direct Application)
    public VisaApplication(String fullName, String passportNo, String nationality,
                           String motherLanguage, String visaType, String gender,
                           String purposeOfVisit, String applicantEmail) {
        this.fullName = fullName;
        this.passportNo = passportNo;
        this.nationality = nationality;
        this.motherLanguage = motherLanguage;
        this.visaType = visaType;
        this.gender = gender;
        this.purposeOfVisit = purposeOfVisit;
        this.applicantEmail = applicantEmail;
        this.applicationId = String.valueOf(rand.nextInt(9000) + 1000);
        this.submissionDate = LocalDate.now().toString();
        this.status = generateRandomStatus();
        this.applicationFee = getFeeForVisaType(visaType);
        this.agentEmail = null;
        this.clientId = null;
    }

    // Constructor for Client Application (through Registered Agent)
    public VisaApplication(String clientId, String fullName, String passportNo, String nationality,
                           String motherLanguage, String visaType, String gender,
                           String agentEmail, String applicantEmail) {
        this.clientId = clientId;
        this.applicationId = clientId;  // Use clientId as applicationId
        this.fullName = fullName;
        this.passportNo = passportNo;
        this.nationality = nationality;
        this.motherLanguage = motherLanguage;
        this.visaType = visaType;
        this.gender = gender;
        this.applicantEmail = applicantEmail;
        this.agentEmail = agentEmail;
        this.submissionDate = LocalDate.now().toString();
        this.status = generateRandomStatus();
        this.applicationFee = getFeeForVisaType(visaType);
        this.purposeOfVisit = null;
    }

    // Getters and Setters
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMotherLanguage() {
        return motherLanguage;
    }

    public void setMotherLanguage(String motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getApplicationFee() {
        return applicationFee;
    }

    public void setApplicationFee(int applicationFee) {
        this.applicationFee = applicationFee;
    }


    public String getRequiredAction() {
        return requiredAction;
    }

    public void setRequiredAction(String requiredAction) {
        this.requiredAction = requiredAction;
    }

    // Utility Methods
    public int getFeeForVisaType(String visaType) {
        return switch (visaType) {
            case "Tourist Visa" -> 6000;
            case "Business Visa" -> 10000;
            case "Student Visa" -> 5000;
            case "Transit Visa" -> 1500;
            case "Work Visa" -> 15000;
            default -> 0;
        };
    }

    private String generateRandomStatus() {
        String[] statuses = {"Pending", "Approved", "Rejected"};
        return statuses[rand.nextInt(statuses.length)];
    }

    public boolean isDirectApplication() {
        return clientId == null;
    }

    public boolean isAgentApplication() {
        return clientId != null;
    }

    @Override
    public String toString() {
        return "VisaApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", nationality='" + nationality + '\'' +
                ", motherLanguage='" + motherLanguage + '\'' +
                ", gender='" + gender + '\'' +
                ", visaType='" + visaType + '\'' +
                ", purposeOfVisit='" + purposeOfVisit + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", status='" + status + '\'' +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", agentEmail='" + agentEmail + '\'' +
                ", applicationFee=" + applicationFee +
                '}';
    }
}
