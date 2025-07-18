package com.popcorntech.app.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popcorntech.app.core.dto.CreatBankAccountRequestDTO;
import com.popcorntech.app.core.dto.ResponseDTO;
import com.popcorntech.app.core.dto.TransferRequestDTO;
import com.popcorntech.app.core.entity.BankAccount;
import com.popcorntech.app.core.entity.User;
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

import java.util.Optional;

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
    @EJB
    private NotificationService notificationService;
    @EJB
    private TransferService transferService;

    @POST
    @Path("/transfer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response transfer(TransferRequestDTO requestDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        try {

            if (requestDTO != null) {

                if (transferService.save(requestDTO).isPresent()) {

                } else {
                    responseDTO.setMessage("Transfer failed");
                }

            } else {
                responseDTO.setMessage("Invalid request");
            }

            return Response.ok().entity(responseDTO).build();
        } catch (Exception e) {
            return Response.ok().entity(responseDTO.setMessage(e.getMessage())).build();
        }


    }

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
                } else if (userService.existsUserByEmail(dto.getEmail())) {
                    responseDTO.setMessage("Email already exists");
                } else if (dto.getMobile() == null || dto.getMobile().isEmpty()) {
                    responseDTO.setMessage("Invalid mobile");
                } else if (dto.getMobile().length() > 10) {
                    responseDTO.setMessage("Invalid mobile");
                } else if (userService.existsUserByMobile(dto.getMobile())) {
                    responseDTO.setMessage("Mobile already exists");
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
                } else if (dto.getAccountType() == null || dto.getAccountType().isEmpty() || !accountTypeService.existsAccountType(dto.getAccountType())) {
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

                    Optional<User> userOptional = userService.addUser(new User().setFirstName(dto.getFirstName()).setLastName(dto.getLastName()).
                            setEmail(dto.getEmail()).setOtp(ValidationUtil.getInstance().passwordGenerator(6))
                            .setMobile(dto.getMobile()).setStreet(dto.getStreet()).setCity(dto.getCity()).setState(dto.getState()).
                            setZipCode(dto.getZipCode()).setIdNO(dto.getIdNO())
                            .setUserStatus(userStatusService.findByName("NOT_VERIFIED").get())
                            .addRoles("USER"));

                    if (userOptional.isPresent()) {

                        Optional<BankAccount> optionalBankAccount = bankAccountService.createAccount(new BankAccount()
                                .setAccountNumber(Long.valueOf(System.currentTimeMillis() + userOptional.get().getId())).
                                setBalance(dto.getDeposit()).setAccountType(accountTypeService.findByName(dto.getAccountType()).get())
                                .setStatus(accountStatusService.findByName("ACTIVE").get()).
                                setUser(userOptional.get()));

                        if (optionalBankAccount.isPresent()) {
                            responseDTO.setMessage(String.valueOf(optionalBankAccount.get().getAccountNumber())).setStatus(true);

                            notificationService.notify(responseDTO);

                        } else {
                            responseDTO.setMessage("New bank account creat failed");
                        }
                    } else {
                        responseDTO.setMessage("New bank account creat failed");
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            responseDTO.setMessage("New bank account creat failed");
        }

        return Response.status(Response.Status.OK).entity(responseDTO).build();

    }

}
