package com.popcorntech.app.web.controller;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;

@Path("/resources")
public class ResourceHelper {

    @Context
    private ServletContext servletContext;

    @GET
    @Path("/css/{file}")
    @Produces("text/css")
    public Response getCss(@PathParam("file") String file) {
        try {

            String cssPath = "/WEB-INF/public/css/" + file;

            InputStream inputStream = servletContext.getResourceAsStream(cssPath);

            if (inputStream == null) {
                System.out.println(file + " not found");
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            byte[] bytes = inputStream.readAllBytes();

            inputStream.close();

            return Response.ok(bytes).header("Content-Type", "text/css").build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
