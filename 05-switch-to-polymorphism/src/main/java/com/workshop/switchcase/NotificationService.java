package com.workshop.switchcase;

public class NotificationService {
    // Dirty: type code switch, duplicate formatting
    public String send(Notification type, String to, String msg){
        return type.send(to, msg);
    }
}
