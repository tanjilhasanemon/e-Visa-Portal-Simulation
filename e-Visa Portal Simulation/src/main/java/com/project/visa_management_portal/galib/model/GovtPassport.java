package com.project.visa_management_portal.galib.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class GovtPassport implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String PassportNO;
    public String IssuingCountry;
    public String FirstName;
    public LocalDate DateOfBirth;
    public String Gender;
    public LocalDate ExpireDate;


    public GovtPassport() {

    }

    public GovtPassport(String passportNO) {
        PassportNO = passportNO;
    }

    public GovtPassport(String passportNO, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate) {
        PassportNO = passportNO;
        IssuingCountry = issuingCountry;
        FirstName = firstName;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        ExpireDate = expireDate;
    }



    public String getPassportNO() {
        return PassportNO;
    }

    public void setPassportNO(String passportNO) {
        PassportNO = passportNO;
    }

    public String getIssuingCountry() {
        return IssuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        IssuingCountry = issuingCountry;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public LocalDate getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        ExpireDate = expireDate;
    }


    @Override
    public String toString() {
        return "GovtPassport{" +
                "PassportNO='" + PassportNO + '\'' +
                ", IssuingCountry='" + IssuingCountry + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Gender='" + Gender + '\'' +
                ", ExpireDate=" + ExpireDate +
                '}';
    }

    public String toString(String dummy) {
        return "GovtPassport{" +
                "PassportNO='" + PassportNO + '\'' +
                ", IssuingCountry='" + IssuingCountry + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Gender='" + Gender + '\'' +
                ", ExpireDate=" + ExpireDate +
                '}';
    }
}
