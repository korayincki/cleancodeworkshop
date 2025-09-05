package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notification;

public class Unknown implements Notification {
    @Override
    public String send(String to, String msg) {
        return "UNKNOWN";
    }
}
