package com.popcorntech.app.web.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/")
public class UIController {

    @GET
    public Viewable index() {
        Viewable viewable = new Viewable("/index","/WEB-INF/views/index.jsp");
        return viewable;
    }

}
