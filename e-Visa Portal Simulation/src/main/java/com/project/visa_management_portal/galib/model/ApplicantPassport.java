package com.project.visa_management_portal.galib.model;

import java.time.LocalDate;

public class ApplicantPassport{
    public String passportNo;
    public String issuingCountry;
    public String firstName;
    public LocalDate dateOfBirth;
    public String gender;
    public LocalDate expireDate;

    public ApplicantPassport(String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate) {
        this.passportNo = passportNo;
        this.issuingCountry = issuingCountry;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.expireDate = expireDate;
    }


    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "ApplicantPassport{" +
                "passportNo='" + passportNo + '\'' +
                ", issuingCountry='" + issuingCountry + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }
}
