package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notification;

public class Sms implements Notification {
    @Override
    public String send(String to, String msg) {
        return "SMS to "+to+": "+msg;
    }
}
