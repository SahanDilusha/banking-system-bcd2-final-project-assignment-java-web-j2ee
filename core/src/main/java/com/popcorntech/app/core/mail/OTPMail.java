package com.popcorntech.app.core.mail;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;

public class OTPMail extends Mailable {
    private String to;
    private String verificationCode;

    public OTPMail(String to, String verificationCode) {
        this.to = to;
        this.verificationCode = verificationCode;
    }

    @Override
    public void build(Message message) throws Exception {
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Verification Mail");

        String link = "<!DOCTYPE html>\n" +
                "            <html lang=\"en\">\n" +
                "            <head>\n" +
                "                <meta charset=\"UTF-8\">\n" +
                "                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "                <title>Verify Your Account</title>\n" +
                "            </head>\n" +
                "            <body style=\"margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f4f4f4;\">\n" +
                "                <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background-color: #f4f4f4; padding: 20px 0;\">\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\">\n" +
                "                            <table cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);\">\n" +
                "                                <!-- Header -->\n" +
                "                                <tr>\n" +
                "                                    <td style=\"background-color: #4CAF50; padding: 40px 0; text-align: center; border-radius: 8px 8px 0 0;\">\n" +
                "                                        <h1 style=\"color: #ffffff; margin: 0; font-size: 28px;\">Bank System</h1>\n" +
                "                                        <p style=\"color: #ffffff; margin: 10px 0 0 0; font-size: 16px;\">Secure Banking Solutions</p>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                \n" +
                "                                <!-- Content -->\n" +
                "                                <tr>\n" +
                "                                    <td style=\"padding: 40px 30px;\">\n" +
                "                                        <h2 style=\"color: #333333; margin: 0 0 20px 0; font-size: 24px;\">Verify Your Account</h2>\n" +
                "                                        \n" +
                "                                        <p style=\"color: #666666; font-size: 16px; line-height: 1.6; margin: 0 0 20px 0;\">\n" +
                "                                            Hello,\n" +
                "                                        </p>\n" +
                "                                        \n" +
                "                                        <p style=\"color: #666666; font-size: 16px; line-height: 1.6; margin: 0 0 30px 0;\">\n" +
                "                                            You've requested to verify your account. Please use the following One-Time Password (OTP) to complete the verification process:\n" +
                "                                        </p>\n" +
                "                                        \n" +
                "                                        <!-- OTP Box -->\n" +
                "                                        <div style=\"background-color: #f8f9fa; border: 2px dashed #4CAF50; border-radius: 8px; padding: 20px; text-align: center; margin: 0 0 30px 0;\">\n" +
                "                                            <p style=\"color: #666666; margin: 0 0 10px 0; font-size: 14px;\">Your OTP Code:</p>\n" +
                "                                            <p style=\"color: #333333; font-size: 32px; font-weight: bold; letter-spacing: 8px; margin: 0;\">" + verificationCode + "</p>\n" +
                "                                        </div>\n" +
                "                                       " +
                "                                       " +
                "                                       " +
                "                                        <!-- Warning Box -->\n" +
                "                                        <div style=\"background-color: #fff3cd; border-left: 4px solid #ffc107; padding: 15px; margin: 0 0 20px 0;\">\n" +
                "                                            <p style=\"color: #856404; margin: 0; font-size: 14px;\">\n" +
                "                                                <strong>Security Notice:</strong> This OTP will expire in 3 minutes. Never share this code with anyone. Our staff will never ask for your OTP.\n" +
                "                                            </p>\n" +
                "                                        </div>\n" +
                "                                        \n" +
                "                                        <p style=\"color: #999999; font-size: 14px; line-height: 1.6; margin: 0;\">\n" +
                "                                            If you didn't request this verification, please ignore this email or contact our support team immediately.\n" +
                "                                        </p>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                \n" +
                "                                <!-- Footer -->\n" +
                "                                <tr>\n" +
                "                                    <td style=\"background-color: #f8f9fa; padding: 30px; text-align: center; border-radius: 0 0 8px 8px;\">\n" +
                "                                        <p style=\"color: #999999; font-size: 14px; margin: 0 0 10px 0;\">\n" +
                "                                            Need help? Contact us at <a href=\"mailto:support@banksystem.com\" style=\"color: #4CAF50; text-decoration: none;\">support@banksystem.com</a>\n" +
                "                                        </p>\n" +
                "                                        <p style=\"color: #999999; font-size: 12px; margin: 0;\">\n" +
                "                                            © 2025 Bank System. All rights reserved.\n" +
                "                                        </p>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </body>\n" +
                "            </html>";

        message.setContent(link, "text/html; charset=utf-8");
    }
}
