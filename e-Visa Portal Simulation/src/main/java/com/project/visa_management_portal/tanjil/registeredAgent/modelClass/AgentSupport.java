package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

import java.time.LocalDateTime;

public class AgentSupport {

    private String supportId;
    private String clientId;
    private String subject;
    private String message;
    private LocalDateTime timestamp;

    public AgentSupport() {
    }

    public AgentSupport(String clientId, String subject, String message) {
        this.supportId = "SUP-" + System.currentTimeMillis();
        this.clientId = clientId;
        this.subject = subject;
        this.message = message;
        this.timestamp = LocalDateTime.now();


    }

    public String getSupportId() {
        return supportId;
    }

    public void setSupportId(String supportId) {
        this.supportId = supportId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AgentSupport{" +
                "supportId='" + supportId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
