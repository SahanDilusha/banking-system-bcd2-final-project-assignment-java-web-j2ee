package com.popcorntech.app.web.controller;

import jakarta.annotation.security.DenyAll;
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

    @DenyAll
    private Response getResponse(String filePath, String type) {
        try {

            String cssPath = "/WEB-INF/public/" + filePath;

            InputStream inputStream = servletContext.getResourceAsStream(cssPath);

            if (inputStream == null) {
                System.out.println(filePath + " not found");
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            byte[] bytes = inputStream.readAllBytes();

            inputStream.close();

            return Response.ok(bytes)
                    .header("Content-Type", type)
                    .header("Content-Length", bytes.length)
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/image/{path}/{file}")
    @Produces("image/png")
    public Response getImages(@PathParam("file") String file, @PathParam("path") String path) {
        return getResponse("image/" + path + "/" + file, "image/png");
    }

    @GET
    @Path("/css/{file}")
    @Produces("text/css")
    public Response getCss(@PathParam("file") String file) {
        return getResponse("css/" + file, "text/css");
    }

    @GET
    @Path("/js/{file}")
    @Produces("application/javascript")
    public Response getJs(@PathParam("file") String file) {
        return getResponse("js/" + file, "application/javascript");
    }


}
