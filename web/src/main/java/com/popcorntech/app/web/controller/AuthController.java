package com.popcorntech.app.web.controller;

import com.popcorntech.app.core.dto.LoginRequestDTO;
import com.popcorntech.app.core.dto.ResponseDTO;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/auth")
public class AuthController {

    @Inject
    private SecurityContext securityContext;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Context HttpServletRequest request, @Context HttpServletResponse response, LoginRequestDTO loginRequest) {

        ResponseDTO responseDTO = new ResponseDTO();

        try {

            if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {

                responseDTO.setMessage("Invalid input!");

                return Response.status(Response.Status.OK).entity(responseDTO).build();
            }

            AuthenticationParameters parameters = AuthenticationParameters.withParams().
                    credential(new UsernamePasswordCredential(loginRequest.getEmail(), loginRequest.getPassword()));

            AuthenticationStatus status = securityContext.authenticate(request, response, parameters);

            System.out.println("Authentication status: " + status);

            if (status == AuthenticationStatus.SUCCESS) {

                responseDTO.setStatus(true);

                return Response.status(Response.Status.OK).entity(responseDTO).build();

            } else {
                responseDTO.setMessage("Invalid credentials!");
                return Response.status(Response.Status.OK).entity(responseDTO).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setMessage("Login failed!");
            return Response.status(Response.Status.OK).entity(responseDTO).build();
        }

    }

}
