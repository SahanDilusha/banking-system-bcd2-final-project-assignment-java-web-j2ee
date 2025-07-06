package com.popcorntech.app.web.security;

import com.popcorntech.app.core.entity.User;
import com.popcorntech.app.core.service.UserService;
import com.popcorntech.app.web.model.ValidationUtil;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;

import java.util.Optional;

@ApplicationScoped
public class IdentityStore implements jakarta.security.enterprise.identitystore.IdentityStore {

    @EJB
    private UserService userService;

    @Override
    public CredentialValidationResult validate(Credential credential) {

        if (credential instanceof UsernamePasswordCredential) {

            Optional<User> userOptional = userService.findUserByEmail(((UsernamePasswordCredential) credential).getCaller());

            if (userOptional.isPresent() && ValidationUtil.getInstance().checkPassword(((UsernamePasswordCredential) credential).getPasswordAsString(), userOptional.get().getPassword())) {
                return new CredentialValidationResult(userOptional.get().getEmail(), userOptional.get().getRoles());
            }

        }

        return CredentialValidationResult.INVALID_RESULT;

    }


}
