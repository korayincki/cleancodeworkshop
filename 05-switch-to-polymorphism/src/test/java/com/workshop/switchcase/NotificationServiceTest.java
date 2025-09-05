package com.workshop.switchcase;

import com.workshop.switchcase.notifications.Email;
import com.workshop.switchcase.notifications.Slack;
import com.workshop.switchcase.notifications.Unknown;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {
    @Test void email(){
        Notification notification = new Email();
        assertTrue(new NotificationService().send(notification,"a@x","hi").startsWith("EMAIL"));
    }
    @Test void slack(){
        Notification notification = new Slack();
        assertTrue(new NotificationService().send(notification,"devs","hi").startsWith("SLACK"));
    }
    @Test void unknown(){
        Notification notification = new Unknown();
        assertEquals("UNKNOWN", new NotificationService().send(notification,"x","hi"));
    }
}
