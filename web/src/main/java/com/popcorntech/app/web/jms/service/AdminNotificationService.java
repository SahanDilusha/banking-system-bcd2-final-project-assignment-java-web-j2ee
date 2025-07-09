package com.popcorntech.app.web.jms.service;


import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/AdminNotificationQueue")
        }
)
public class AdminNotificationService implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {

            if (message instanceof TextMessage) {
                System.out.println("AdminNotificationService onMessage " + ((TextMessage) message).getText());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
