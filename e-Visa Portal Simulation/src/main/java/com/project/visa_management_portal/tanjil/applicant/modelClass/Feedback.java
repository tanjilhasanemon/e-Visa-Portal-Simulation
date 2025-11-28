package com.project.visa_management_portal.tanjil.applicant.modelClass;

import java.time.LocalDate;
import java.util.UUID;

public class Feedback {

    private String subject;
    private String message;
    private String senderId;   // applicantId or agentId
    private String date;


    public Feedback() { }

    public Feedback(String senderId, String subject, String message) {
        this.senderId =  UUID.randomUUID().toString();
        this.subject = subject == null ? "" : subject.trim();
        this.message = message == null ? "" : message.trim();
        this.date = LocalDate.now().toString();

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

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", senderId='" + senderId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
