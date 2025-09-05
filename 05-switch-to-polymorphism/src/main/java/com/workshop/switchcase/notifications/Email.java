package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notification;

public class Email implements Notification {
    @Override
    public String send(String to, String msg) {
        return "EMAIL to "+to+": "+msg;
    }
}
