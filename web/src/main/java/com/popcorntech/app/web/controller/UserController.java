package com.popcorntech.app.web.controller;

import com.popcorntech.app.core.dto.LoginRequestDTO;
import com.popcorntech.app.core.dto.ResponseDTO;
import com.popcorntech.app.core.entity.User;
import com.popcorntech.app.core.service.UserService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/api/v1")
public class UserController {

    @EJB
    private UserService userService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequestDTO loginRequest) {

        try {

            if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity(new ResponseDTO("Invalid Input!", false)).build();
            }

            Optional<User> user = userService.findUserByEmail(loginRequest.getEmail());

            if (user.isPresent()) {
                System.out.println("User logged in");
            } else {
                System.out.println("User logged out");
            }

            System.out.println(loginRequest.getEmail());
            System.out.println(loginRequest.getPassword());

            return Response.status(Response.Status.OK).entity(new ResponseDTO("", true)).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ResponseDTO("Internal server error!", false)).build();
        }

    }

}
