package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notification;

public class Push implements Notification {
    @Override
    public String send(String to, String msg) {
        return "PUSH to "+to+": "+msg;
    }
}
