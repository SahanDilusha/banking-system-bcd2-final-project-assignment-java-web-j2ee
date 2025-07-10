package com.popcorntech.app.web.config;

import com.popcorntech.app.web.websocket.AdminNotificationWebSocket;
import jakarta.websocket.Endpoint;
import jakarta.websocket.server.ServerApplicationConfig;
import jakarta.websocket.server.ServerEndpointConfig;

import java.util.HashSet;
import java.util.Set;

public class WebSocketConfig implements ServerApplicationConfig {
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        Set<ServerEndpointConfig> result = new HashSet<>();

        if (set.contains(AdminNotificationWebSocket.class)) {
            result.add(ServerEndpointConfig.Builder
                    .create(AdminNotificationWebSocket.class, "/notification_socket_admin")
                    .build());
        }

        return result;    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        return Set.of();
    }
}
