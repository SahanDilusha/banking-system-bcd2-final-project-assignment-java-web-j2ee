package com.popcorntech.app.web.controller;

import com.popcorntech.app.core.dto.LoginRequestDTO;
import com.popcorntech.app.core.dto.ResponseDTO;
import com.popcorntech.app.core.dto.UserRegisterRequestDTO;
import com.popcorntech.app.core.service.ActiveUserManagerService;
import com.popcorntech.app.core.service.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
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

    @EJB
    private UserService userService;
    @EJB
    private ActiveUserManagerService activeUserManagerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response registerUser(UserRegisterRequestDTO registerRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {


        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setMessage("Register failed!");
            return Response.status(Response.Status.OK).entity(responseDTO).build();
        }
        return null;
    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response login(@Context HttpServletRequest request, @Context HttpServletResponse response, LoginRequestDTO loginRequest) {

        System.out.println("login api call");

        ResponseDTO responseDTO = new ResponseDTO();

        try {

            if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
                responseDTO.setMessage("Invalid input!");
            } else {
                AuthenticationParameters parameters = AuthenticationParameters.withParams().
                        credential(new UsernamePasswordCredential(loginRequest.getEmail(), loginRequest.getPassword()));

                AuthenticationStatus status = securityContext.authenticate(request, response, parameters);

                System.out.println("Authentication status: " + status);

                if (status == AuthenticationStatus.SUCCESS) {

                    responseDTO.setStatus(true);
                    activeUserManagerService.setSession(request.getSession().getId(), userService.findUserByEmail(loginRequest.getEmail()).get());

                } else {
                    responseDTO.setMessage("Invalid credentials!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setMessage("Login failed!");

        }
        return Response.status(Response.Status.OK).entity(responseDTO).build();
    }

    @POST
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request) {
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            activeUserManagerService.removeSession(request.getSession().getId());
            request.getSession().invalidate();
            responseDTO.setMessage("Logout successful!");
            responseDTO.setStatus(true);
        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setMessage("Logout failed!");
        }

        return Response.status(Response.Status.OK).entity(responseDTO).build();

    }

}
