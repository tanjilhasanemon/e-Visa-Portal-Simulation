package com.project.visa_management_portal.galib.model;

import java.io.Serializable;
import java.time.LocalDate;


public class Document implements Serializable {
    public String ApplicantId;
    public String passportNo;
    public String issuingCountry;
    public String firstName;
    public LocalDate dateOfBirth;
    public String gender;
    public LocalDate expireDate;
    public boolean paymentStatus;

    public boolean passportVerified;

    public String GovtPassportNO;
    public String GovtIssuingCountry;
    public String GovtFirstName;
    public LocalDate GovtDateOfBirth;
    public String GovtGender;
    public LocalDate GovtExpireDate;

    public boolean isVerified;


    public String visaId;
    public String visaNumber;
    public  LocalDate issuedOn;
    public  LocalDate validFrom;
    public  LocalDate validUntil;
    public  String issuedBy;

    // Full Constructor
    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified, String visaId, String visaNumber, LocalDate issuedOn, LocalDate validFrom, LocalDate validUntil, String issuedBy) {
        ApplicantId = applicantId;
        this.passportNo = passportNo;
        this.issuingCountry = issuingCountry;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.expireDate = expireDate;
        this.paymentStatus = paymentStatus;
        this.passportVerified = passportVerified;
        GovtPassportNO = govtPassportNO;
        GovtIssuingCountry = govtIssuingCountry;
        GovtFirstName = govtFirstName;
        GovtDateOfBirth = govtDateOfBirth;
        GovtGender = govtGender;
        GovtExpireDate = govtExpireDate;
        this.isVerified = isVerified;
        this.visaId = visaId;
        this.visaNumber = visaNumber;
        this.issuedOn = issuedOn;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.issuedBy = issuedBy;
    }
    // Applicant Passport Constructor
    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified) {
        ApplicantId = applicantId;
        this.passportNo = passportNo;
        this.issuingCountry = issuingCountry;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.expireDate = expireDate;
        this.paymentStatus = paymentStatus;
        this.passportVerified = passportVerified;
    }
// Government Passport Constructor
    public Document(String applicantId, String govtPassportNO, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate) {
        ApplicantId = applicantId;
        GovtPassportNO = govtPassportNO;
        //this.passportNo = passportNo;
        this.issuingCountry = issuingCountry;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.expireDate = expireDate;
        //this.passportVerified = passportVerified;
    }

    // Visa Constructor

    public Document(boolean isVerified, String firstName, String passportNo, String visaId, String visaNumber, LocalDate issuedOn, LocalDate validFrom, LocalDate validUntil, String issuedBy) {
        this.isVerified = isVerified;
        this.firstName = firstName;
        this.passportNo = passportNo;
        this.visaId = visaId;
        this.visaNumber = visaNumber;
        this.issuedOn = issuedOn;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.issuedBy = issuedBy;
    }


    //verfication Constructor
    public Document(String applicantId, String passportNo, String issuingCountry, String firstName, LocalDate dateOfBirth, String gender, LocalDate expireDate, boolean paymentStatus, boolean passportVerified, String govtPassportNO, String govtIssuingCountry, String govtFirstName, LocalDate govtDateOfBirth, String govtGender, LocalDate govtExpireDate, boolean isVerified) {
        ApplicantId = applicantId;
        this.passportNo = passportNo;
        this.issuingCountry = issuingCountry;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.expireDate = expireDate;
        this.paymentStatus = paymentStatus;
        this.passportVerified = passportVerified;
        GovtPassportNO = govtPassportNO;
        GovtIssuingCountry = govtIssuingCountry;
        GovtFirstName = govtFirstName;
        GovtDateOfBirth = govtDateOfBirth;
        GovtGender = govtGender;
        GovtExpireDate = govtExpireDate;
        this.isVerified = isVerified;
    }

    public String getApplicantId() {
        return ApplicantId;
    }

    public void setApplicantId(String applicantId) {
        ApplicantId = applicantId;
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

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean isPassportVerified() {
        return passportVerified;
    }

    public void setPassportVerified(boolean passportVerified) {
        this.passportVerified = passportVerified;
    }

    public String getGovtPassportNO() {
        return GovtPassportNO;
    }

    public void setGovtPassportNO(String govtPassportNO) {
        GovtPassportNO = govtPassportNO;
    }

    public String getGovtIssuingCountry() {
        return GovtIssuingCountry;
    }

    public void setGovtIssuingCountry(String govtIssuingCountry) {
        GovtIssuingCountry = govtIssuingCountry;
    }

    public String getGovtFirstName() {
        return GovtFirstName;
    }

    public void setGovtFirstName(String govtFirstName) {
        GovtFirstName = govtFirstName;
    }

    public LocalDate getGovtDateOfBirth() {
        return GovtDateOfBirth;
    }

    public void setGovtDateOfBirth(LocalDate govtDateOfBirth) {
        GovtDateOfBirth = govtDateOfBirth;
    }

    public String getGovtGender() {
        return GovtGender;
    }

    public void setGovtGender(String govtGender) {
        GovtGender = govtGender;
    }

    public LocalDate getGovtExpireDate() {
        return GovtExpireDate;
    }

    public void setGovtExpireDate(LocalDate govtExpireDate) {
        GovtExpireDate = govtExpireDate;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getVisaId() {
        return visaId;
    }

    public void setVisaId(String visaId) {
        this.visaId = visaId;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public LocalDate getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(LocalDate issuedOn) {
        this.issuedOn = issuedOn;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    @Override
    public String toString() {
        return "Document{" +
                "ApplicantId='" + ApplicantId + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", issuingCountry='" + issuingCountry + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", expireDate=" + expireDate +
                ", paymentStatus=" + paymentStatus +
                ", passportVerified=" + passportVerified +
                ", GovtPassportNO='" + GovtPassportNO + '\'' +
                ", GovtIssuingCountry='" + GovtIssuingCountry + '\'' +
                ", GovtFirstName='" + GovtFirstName + '\'' +
                ", GovtDateOfBirth=" + GovtDateOfBirth +
                ", GovtGender='" + GovtGender + '\'' +
                ", GovtExpireDate=" + GovtExpireDate +
                ", isVerified=" + isVerified +
                ", visaId='" + visaId + '\'' +
                ", visaNumber='" + visaNumber + '\'' +
                ", issuedOn=" + issuedOn +
                ", validFrom=" + validFrom +
                ", validUntil=" + validUntil +
                ", issuedBy='" + issuedBy + '\'' +
                '}';
    }


    //    public String getApplicantId() {
//        return ApplicantId;
//    }
//
//    public void setApplicantId(String applicantId) {
//        ApplicantId = applicantId;
//    }
//
//    public String getPassportNo() {
//        return passportNo;
//    }
//
//    public void setPassportNo(String passportNo) {
//        this.passportNo = passportNo;
//    }
//
//    public String getIssuingCountry() {
//        return issuingCountry;
//    }
//
//    public void setIssuingCountry(String issuingCountry) {
//        this.issuingCountry = issuingCountry;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public LocalDate getExpireDate() {
//        return expireDate;
//    }
//
//    public void setExpireDate(LocalDate expireDate) {
//        this.expireDate = expireDate;
//    }
//
//    public boolean isPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(boolean paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    public boolean isPassportVerified() {
//        return passportVerified;
//    }
//
//    public void setPassportVerified(boolean passportVerified) {
//        this.passportVerified = passportVerified;
//    }
//
//    public String getGovtPassportNO() {
//        return GovtPassportNO;
//    }
//
//    public void setGovtPassportNO(String govtPassportNO) {
//        GovtPassportNO = govtPassportNO;
//    }
//
//    public String getGovtIssuingCountry() {
//        return GovtIssuingCountry;
//    }
//
//    public void setGovtIssuingCountry(String govtIssuingCountry) {
//        GovtIssuingCountry = govtIssuingCountry;
//    }
//
//    public String getGovtFirstName() {
//        return GovtFirstName;
//    }
//
//    public void setGovtFirstName(String govtFirstName) {
//        GovtFirstName = govtFirstName;
//    }
//
//    public LocalDate getGovtDateOfBirth() {
//        return GovtDateOfBirth;
//    }
//
//    public void setGovtDateOfBirth(LocalDate govtDateOfBirth) {
//        GovtDateOfBirth = govtDateOfBirth;
//    }
//
//    public String getGovtGender() {
//        return GovtGender;
//    }
//
//    public void setGovtGender(String govtGender) {
//        GovtGender = govtGender;
//    }
//
//    public LocalDate getGovtExpireDate() {
//        return GovtExpireDate;
//    }
//
//    public void setGovtExpireDate(LocalDate govtExpireDate) {
//        GovtExpireDate = govtExpireDate;
//    }
//
//    public boolean isVerified() {
//        return isVerified;
//    }
//
//    public void setVerified(boolean verified) {
//        isVerified = verified;
//    }
//
//    public String getVisaId() {
//        return visaId;
//    }
//
//    public void setVisaId(String visaId) {
//        this.visaId = visaId;
//    }
//
//    public String getVisaNumber() {
//        return visaNumber;
//    }
//
//    public void setVisaNumber(String visaNumber) {
//        this.visaNumber = visaNumber;
//    }
//
//    public LocalDate getIssuedOn() {
//        return issuedOn;
//    }
//
//    public void setIssuedOn(LocalDate issuedOn) {
//        this.issuedOn = issuedOn;
//    }
//
//    public LocalDate getValidFrom() {
//        return validFrom;
//    }
//
//    public void setValidFrom(LocalDate validFrom) {
//        this.validFrom = validFrom;
//    }
//
//    public LocalDate getValidUntil() {
//        return validUntil;
//    }
//
//    public void setValidUntil(LocalDate validUntil) {
//        this.validUntil = validUntil;
//    }
//
//    public String getIssuedBy() {
//        return issuedBy;
//    }
//
//    public void setIssuedBy(String issuedBy) {
//        this.issuedBy = issuedBy;
//    }

//    @Override
//    public String toString() {
//        return "Document{" +
//                "ApplicantId='" + ApplicantId + '\'' +
//                ", passportNo='" + passportNo + '\'' +
//                ", issuingCountry='" + issuingCountry + '\'' +
//                ", firstName='" + firstName + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
//                ", gender='" + gender + '\'' +
//                ", expireDate=" + expireDate +
//                ", paymentStatus=" + paymentStatus +
//                ", passportVerified=" + passportVerified +
//                ", GovtPassportNO='" + GovtPassportNO + '\'' +
//                ", GovtIssuingCountry='" + GovtIssuingCountry + '\'' +
//                ", GovtFirstName='" + GovtFirstName + '\'' +
//                ", GovtDateOfBirth=" + GovtDateOfBirth +
//                ", GovtGender='" + GovtGender + '\'' +
//                ", GovtExpireDate=" + GovtExpireDate +
//                ", isVerified=" + isVerified +
//                ", visaId='" + visaId + '\'' +
//                ", visaNumber='" + visaNumber + '\'' +
//                ", issuedOn=" + issuedOn +
//                ", validFrom=" + validFrom +
//                ", validUntil=" + validUntil +
//                ", issuedBy='" + issuedBy + '\'' +
//                '}';
//    }



}
