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

    Random rand = new Random();

    public VisaApplication() {
    }


    public VisaApplication(String fullName, String passportNo, String nationality, String motherLanguage, String visaType, String gender, String purposeOfVisit) {
        this.fullName = fullName;
        this.passportNo = passportNo;
        this.nationality = nationality;
        this.motherLanguage = motherLanguage;
        this.visaType = visaType;
        this.gender = gender;
        this.purposeOfVisit = purposeOfVisit;
        this.applicationId = String.valueOf(rand.nextInt(9999 - 1000 + 1) + 1000);
        this.submissionDate = LocalDate.now().toString();
    }


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

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }


    @Override
    public String toString() {
        return "VisaApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", nationality='" + nationality + '\'' +
                ", motherLanguage='" + motherLanguage + '\'' +
                ", gender='" + gender + '\'' +
                ", visaType='" + visaType + '\'' +
                ", purposeOfVisit='" + purposeOfVisit + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", rand=" + rand +
                '}';
    }


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

    public String getFeeBdt() {
        return "";
    }

    public String getStatus() {
        return "";
    }
}
