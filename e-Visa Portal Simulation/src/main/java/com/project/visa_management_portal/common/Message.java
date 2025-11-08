package com.project.visa_management_portal.common;

/*
 Suggested methods:
 // public void send();
 // public void markResolved();
*/

import java.time.LocalDate;

public class Message {
    public int messageId;
    public int senderId;
    public int receiverId;   // support or internal id
    public String subject;
    public String content;
    public LocalDate sentDate;
    public String status;       // "OPEN","RESOLVED"
}
