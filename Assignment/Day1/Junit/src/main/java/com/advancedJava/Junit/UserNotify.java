package com.advancedJava.Junit;

public class UserNotify {

    private NotificationService notificationService;

    public UserNotify(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String name) {
        // Some logic...
        notificationService.sendNotification("Welcome my bro!!");
    }
}
