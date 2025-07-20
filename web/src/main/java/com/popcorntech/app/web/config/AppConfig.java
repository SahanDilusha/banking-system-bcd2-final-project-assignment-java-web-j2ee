package com.popcorntech.app.web.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class AppConfig extends ResourceConfig {

    public AppConfig() {
        packages("com.popcorntech.app.web.controller");
        packages("com.popcorntech.app.web.websocket");

        register(JspMvcFeature.class);
        register(DependencyBinder.class);

        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");

    }

}
