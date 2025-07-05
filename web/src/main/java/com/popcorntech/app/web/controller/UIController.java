package com.popcorntech.app.web.controller;

import jakarta.annotation.security.DenyAll;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;

import java.net.MalformedURLException;

@Path("/")
public class UIController {

    @Context
    private ServletContext servletContext;

    @GET
    public Viewable index() {

        return getViewable("index");
    }

    @GET
    @Path("/admin/{path}")
    public Viewable admin(@PathParam("path") String path) {
        return getViewable(path);
    }

    @DenyAll
    private Viewable getViewable(String path) {

        try {
            if (servletContext.getResource("/WEB-INF/views/" + path + ".jsp") == null) {

                throw new WebApplicationException(
                        Response.status(Response.Status.NOT_FOUND).entity(
                                new Viewable("/404", "/WEB-INF/views/error-pages/404.jsp")).build()
                );

            }

            return new Viewable("/" + path, "/WEB-INF/views/" + path + ".jsp");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}
