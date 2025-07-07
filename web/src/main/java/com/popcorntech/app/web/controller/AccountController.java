package com.popcorntech.app.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popcorntech.app.core.dto.CreatBankAccountRequestDTO;
import com.popcorntech.app.core.dto.ResponseDTO;
import com.popcorntech.app.core.service.*;
import com.popcorntech.app.core.util.ValidationUtil;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/api/v1/account")
public class AccountController {

    @EJB
    private BankAccountService bankAccountService;
    @EJB
    private UserService userService;
    @EJB
    private AccountTypeService accountTypeService;
    @EJB
    private IDTypeService idTypeService;
    @EJB
    private UserStatusService userStatusService;
    @EJB
    private RolesService rolesService;
    @EJB
    private AccountStatusService accountStatusService;

    @POST
    @Path("/create")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response creatBankAccount(@FormDataParam("dto") String json) {

        ResponseDTO responseDTO = new ResponseDTO();

        CreatBankAccountRequestDTO dto = null;

        try {

            if (json == null || json.isEmpty()) {
                responseDTO.setMessage("Invalid request");
            } else {

                dto = new ObjectMapper().readValue(json, CreatBankAccountRequestDTO.class);

                if (dto == null) {
                    responseDTO.setMessage("Invalid request");
                } else if (dto.getFirstName() == null || dto.getFirstName().isEmpty()) {
                    responseDTO.setMessage("Invalid first name");
                } else if (dto.getFirstName().length() > 45) {
                    responseDTO.setMessage("Invalid first name");
                } else if (dto.getLastName() == null || dto.getLastName().isEmpty()) {
                    responseDTO.setMessage("Invalid last name");
                } else if (dto.getLastName().length() > 45) {
                    responseDTO.setMessage("Invalid last name");
                } else if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
                    responseDTO.setMessage("Invalid email");
                } else if (dto.getEmail().length() > 100) {
                    responseDTO.setMessage("Invalid email");
                } else if (!ValidationUtil.getInstance().validateEmail(dto.getEmail())) {
                    responseDTO.setMessage("Invalid email");
                } else if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
                    responseDTO.setMessage("Invalid password");
                } else if (!ValidationUtil.getInstance().validatePassword(dto.getPassword())) {
                    responseDTO.setMessage("Invalid password");
                } else if (dto.getMobile() == null || dto.getMobile().isEmpty()) {
                    responseDTO.setMessage("Invalid mobile");
                } else if (dto.getMobile().length() > 10) {
                    responseDTO.setMessage("Invalid mobile");
                } else if (dto.getStreet() == null || dto.getStreet().isEmpty()) {
                    responseDTO.setMessage("Invalid street");
                } else if (dto.getStreet().length() > 45) {
                    responseDTO.setMessage("Invalid street");
                } else if (dto.getCity() == null || dto.getCity().isEmpty()) {
                    responseDTO.setMessage("Invalid city");
                } else if (dto.getCity().length() > 45) {
                    responseDTO.setMessage("Invalid city");
                } else if (dto.getState() == null || dto.getState().isEmpty()) {
                    responseDTO.setMessage("Invalid state");
                } else if (dto.getState().length() > 45) {
                    responseDTO.setMessage("Invalid state");
                } else if (dto.getZipCode() == null || dto.getZipCode().isEmpty()) {
                    responseDTO.setMessage("Invalid zip code");
                } else if (dto.getZipCode().length() > 20) {
                    responseDTO.setMessage("Invalid zip code");
                } else if (dto.getAccountType() == null || dto.getAccountType().isEmpty() || !idTypeService.existsIDType(dto.getAccountType())) {
                    responseDTO.setMessage("Invalid account type");
                } else if (dto.getDeposit() == null || dto.getDeposit() < 0) {
                    responseDTO.setMessage("Invalid deposit");
                } else if (dto.getIdType() == null || dto.getIdType().isEmpty() || !idTypeService.existsIDType(dto.getIdType())) {
                    responseDTO.setMessage("Invalid id type");
                } else if (dto.getIdNO() == null || dto.getIdNO().isEmpty()) {
                    responseDTO.setMessage("Invalid ID Number");
                } else if (dto.getIdNO().length() > 20) {
                    responseDTO.setMessage("Invalid ID Number");
                } else {


                }


            }
            
            return Response.ok(responseDTO).entity(responseDTO).build();

        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setMessage("New bank account creat failed");
            return Response.status(Response.Status.OK).entity(responseDTO).build();
        }

    }

}
