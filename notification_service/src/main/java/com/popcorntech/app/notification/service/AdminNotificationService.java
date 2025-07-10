package com.popcorntech.app.notification.service;

import com.popcorntech.app.core.dto.ResponseDTO;
import com.popcorntech.app.core.service.NotificationService;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;

@Singleton
public class AdminNotificationService implements NotificationService {

    @Resource(lookup = "jms/AdminNotificationConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/AdminNotificationQueue")
    private Queue queue;

    @Override
    public void notify(ResponseDTO responseDTO) {

        try {
            JMSContext context = connectionFactory.createContext();

            ObjectMessage objectMessage = context.createObjectMessage(responseDTO);

            context.createProducer().send(queue, objectMessage);
            System.out.println("Message sent");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
