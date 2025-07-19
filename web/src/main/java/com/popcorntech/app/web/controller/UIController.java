package com.popcorntech.app.web.controller;

import com.popcorntech.app.core.entity.Transfer;
import com.popcorntech.app.core.util.ValidationUtil;
import jakarta.annotation.security.DenyAll;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        System.out.println("index method ui");
        return getViewable("index");
    }

    @GET
    @Path("/admin")
    public Viewable adminIndex() {
        return getViewable("admin/index");
    }

    @GET
    @Path("/user")
    public Viewable userIndex() {
        return getViewable("user/index");
    }

    @GET
    @Path("/admin/{path}")
    public Viewable adminPages(@PathParam("path") String path) {
        return getViewable("admin/" + path);
    }

    @GET
    @Path("/user/{path}")
    public Viewable userPages(@PathParam("path") String path) {
        return getViewable("user/" + path);
    }

    @GET
    @Path("/register")
    public Viewable register() {
        return getViewable("register");
    }

    @GET
    @Path("/user/transfer-otp-verification")
    public Viewable transferVerification(@Context HttpServletRequest request, @Context HttpServletResponse response) {

        String hashedPassword = request.getParameter("hs");
        System.out.println(hashedPassword);

        Transfer transfer = (Transfer) request.getSession().getAttribute("new_transfer");

        if (transfer != null) {

            String hasp = String.valueOf(transfer.getId()) + String.valueOf(transfer.getFromAccount()) + String.valueOf(transfer.getToAccount()) + String.valueOf(transfer.getAmount()) + transfer.getOtp();

            if (ValidationUtil.getInstance().checkPassword(hasp, hashedPassword)) {
                return getViewable("user/transfer-otp-verification");
            }

        }

        throw new WebApplicationException(Response.Status.UNAUTHORIZED);

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
