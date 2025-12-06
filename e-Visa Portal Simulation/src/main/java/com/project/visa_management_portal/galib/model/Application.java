package com.project.visa_management_portal.galib.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {
    public enum Status { DRAFT, SUBMITTED, UNDER_REVIEW, APPROVED, REJECTED, ISSUED }

    private final String appId;
    private final String applicantId;
    private Status status;
    private boolean createdByAgent = false;

    private final List<Document> documents = new ArrayList<>();
    private final List<TravelHistory> travelHistories = new ArrayList<>();
    private EVisa eVisa;
    private final List<String> auditLog = new ArrayList<>();

    public Application(String applicantId, String purpose) {
        this.appId = UUID.randomUUID().toString();
        this.applicantId = applicantId;
        this.status = Status.DRAFT;
    }

    public String getAppId() { return appId; }
    public String getApplicantId() { return applicantId; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public void addDocument(Document d) { documents.add(d); }
    public List<Document> getDocuments() { return documents; }

    public void addTravelHistory(TravelHistory t) { travelHistories.add(t); }
    public List<TravelHistory> getTravelHistories() { return travelHistories; }


    public EVisa getEVisa() { return eVisa; }
    public void setEVisa(EVisa eVisa) { this.eVisa = eVisa; }

    public void addAuditLog(String entry) { auditLog.add(Instant.now() + " - " + entry); }
    public List<String> getAuditLog() { return auditLog; }

    public boolean isCreatedByAgent() { return createdByAgent; }
    public void setCreatedByAgent(boolean createdByAgent) { this.createdByAgent = createdByAgent; }
}
