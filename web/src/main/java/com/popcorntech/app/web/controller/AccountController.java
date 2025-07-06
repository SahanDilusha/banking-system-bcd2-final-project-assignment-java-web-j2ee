package com.popcorntech.app.web.controller;

import com.popcorntech.app.core.dto.CreatBankAccountRequestDTO;
import com.popcorntech.app.core.dto.ResponseDTO;
import com.popcorntech.app.core.service.BankAccountService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/account")
public class AccountController {
    
    @EJB
    private BankAccountService bankAccountService;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response creatBankAccount(CreatBankAccountRequestDTO accountRequest) {

        ResponseDTO responseDTO = new ResponseDTO();

        try {

            if (accountRequest == null) {
                responseDTO.setMessage("Invalid request");
            } else if () {
                
            }

        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setMessage("New bank account creat failed");
            return Response.status(Response.Status.OK).entity(responseDTO).build();
        }

    }

}
