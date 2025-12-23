package com.project.visa_management_portal.galib.model;

import java.time.LocalDate;
import java.util.Arrays;

public class DummyGovtPassport {
    public final String PassportNO;
    public final String IssuingCountry;
    public final String FirstName;
    public final LocalDate DateOfBirth;
    public final String Gender;
    public final LocalDate ExpireDate;

    public DummyGovtPassport(String passportNO, String issuingCountry, String firstName, LocalDate dob, String gender, LocalDate expireDate) {
        this.PassportNO = passportNO;
        this.IssuingCountry = issuingCountry;
        this.FirstName = firstName;
        this.DateOfBirth = dob;
        this.Gender = gender;
        this.ExpireDate = expireDate;
    }

    String[][] dummyGovtPassportList = {
            {"PassportNO", "IssuingCountry", "FirstName", "DateOfBirth", "Gender", "ExpireDate"},

            {"P100001", "BD", "Alice",      "1995-03-12", "F", "2028-03-11"},
            {"P100002", "BD", "Rakib",      "1990-05-20", "M", "2027-05-19"},
            {"P100003", "IN", "Sonia",      "1988-11-02", "F", "2030-11-01"},
            {"P100004", "PK", "Zahid",      "1992-01-15", "M", "2029-01-14"},
            {"P100005", "BD", "Mim",        "1999-07-22", "F", "2026-07-21"},
            {"P100006", "NP", "Arjun",      "1991-02-02", "M", "2028-02-01"},
            {"P100007", "LK", "Nimali",     "1987-09-05", "F", "2027-09-04"},
            {"P100008", "BD", "Karim",      "1985-12-30", "M", "2030-12-29"},
            {"P100009", "CN", "Wei",        "1993-06-18", "M", "2029-06-17"},
            {"P100010", "US", "Emily",      "1997-08-09", "F", "2032-08-08"}
    };

    public String getPassportNO() {
        return PassportNO;
    }

    public String getIssuingCountry() {
        return IssuingCountry;
    }

    public String getFirstName() {
        return FirstName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public LocalDate getExpireDate() {
        return ExpireDate;
    }

    public String[][] getDummyGovtPassportList() {
        return dummyGovtPassportList;
    }

    public void setDummyGovtPassportList(String[][] dummyGovtPassportList) {
        this.dummyGovtPassportList = dummyGovtPassportList;
    }

    @Override
    public String toString() {
        return "DummyGovtPassport{" +
                "PassportNO='" + PassportNO + '\'' +
                ", IssuingCountry='" + IssuingCountry + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Gender='" + Gender + '\'' +
                ", ExpireDate=" + ExpireDate +
                ", dummyGovtPassportList=" + Arrays.toString(dummyGovtPassportList) +
                '}';
    }
}
