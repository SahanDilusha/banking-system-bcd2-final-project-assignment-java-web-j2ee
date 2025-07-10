package com.popcorntech.app.web.websocket;

import jakarta.annotation.security.PermitAll;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/notification_socket_admin")
@PermitAll
public class AdminNotificationWebSocket {

    private final static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("AdminNotificationService onOpen");
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("AdminNotificationService onClose");
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("AdminNotificationService onError");
        sessions.remove(session);
    }

    public static void broadcast(Object message) {
        synchronized (sessions) {
            for (Session session : sessions) {
                try {
                    session.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
