package com.see0gan.demo.service;

import com.see0gan.user.registration.RegistrationService;
import com.see0gan.utils.email.EmailService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    private final EmailService emailService;
    private final RegistrationService registrationService;

    @Autowired
    public EmailServiceTest(EmailService emailService, RegistrationService registrationService) {
        this.emailService = emailService;
        this.registrationService = registrationService;
    }

    @Test
    public void sendEmail(){

        String link = "http://localhost:8080/api/v1/registration/confirm?token=38704d66-27ba-4069-8263-1cd126e4fc01";
      //  emailService.send("testSpring30@gmail.com", registrationService.buildEmail("Emma", link));
    }
}
