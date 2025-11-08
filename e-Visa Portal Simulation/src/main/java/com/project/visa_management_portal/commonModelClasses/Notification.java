package com.project.visa_management_portal.commonModelClasses;

import java.util.Date;

public class Notification {
    private String notificationId;
    private String userId;
    private String message;
    private Date createdAt;
    private boolean isRead;

    // Methods: markAsRead(), sendNotification(), getNotifications()
}
