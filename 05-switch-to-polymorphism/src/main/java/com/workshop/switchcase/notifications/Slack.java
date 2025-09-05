package com.workshop.switchcase.notifications;

import com.workshop.switchcase.Notification;

public class Slack implements Notification {
    @Override
    public String send(String to, String msg) {
        return "SLACK @"+to+": "+msg;
    }
}
