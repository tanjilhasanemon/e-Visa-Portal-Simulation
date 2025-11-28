package com.project.visa_management_portal.galib.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class EVisa {
    private final String visaId;
    private final String visaNumber;
    private final String applicantId;
    private final LocalDateTime issuedOn;
    private final LocalDate validFrom;
    private final LocalDate validUntil;
    private final String issuedBy;

    public EVisa(String applicantId, String issuedBy) {
        this.visaId = UUID.randomUUID().toString();
        this.visaNumber = generateVisaNumber();
        this.applicantId = applicantId;
        this.issuedBy = issuedBy;
        this.issuedOn = LocalDateTime.now();
        this.validFrom = LocalDate.now();
        this.validUntil = validFrom.plusMonths(6); // example validity
    }

    private String generateVisaNumber() {
        return "EV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getVisaId() { return visaId; }
    public String getVisaNumber() { return visaNumber; }
    public String getApplicantId() { return applicantId; }
    public LocalDateTime getIssuedOn() { return issuedOn; }
    public LocalDate getValidFrom() { return validFrom; }
    public LocalDate getValidUntil() { return validUntil; }
    public String getIssuedBy() { return issuedBy; }
}
