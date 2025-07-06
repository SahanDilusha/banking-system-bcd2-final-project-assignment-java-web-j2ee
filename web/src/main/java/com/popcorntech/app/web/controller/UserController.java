package com.popcorntech.app.web.controller;

import com.popcorntech.app.core.dto.LoginRequestDTO;
import com.popcorntech.app.core.dto.ResponseDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/api/v1/user")
public class UserController {


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequestDTO loginRequest) {

        ResponseDTO responseDTO = new ResponseDTO();

        return null;

    }

}
