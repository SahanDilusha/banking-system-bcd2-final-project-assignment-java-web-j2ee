package com.popcorntech.app.core.util;

import org.mindrot.jbcrypt.BCrypt;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static ValidationUtil validationUtil;
    private final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*!";

    private ValidationUtil() {

    }

    public final static ValidationUtil getInstance() {

        if (validationUtil == null) {
            validationUtil = new ValidationUtil();
        }
        return validationUtil;
    }

    public final boolean validateEmail(String email) {
        return Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$").matcher(email).find();
    }

    public final boolean validatePassword(String password) {
        return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,50}$").matcher(password).find();
    }

    public final String passwordGenerator(int length) {

        SecureRandom secureRandom = new SecureRandom();

        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(CHAR_SET.length());
            password.append(CHAR_SET.charAt(index));
        }

        return String.valueOf(password);
    }

    public final String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());

    }

    public final boolean checkPassword(String password, String hashedPassword) {

        return BCrypt.checkpw(password, hashedPassword);

    }

}
