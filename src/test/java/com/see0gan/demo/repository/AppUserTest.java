package com.see0gan.demo.repository;


import com.see0gan.demo.auth.AppUserRepository;
import com.see0gan.demo.auth.ApplicationUser;
import com.see0gan.demo.auth.ApplicationUserService;
import com.see0gan.demo.registration.token.ConfirmationTokenService;
import com.see0gan.demo.security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@AllArgsConstructor
public class AppUserTest {

    private ApplicationUserService applicationUserService;// = new ApplicationUserService();
    private final BCryptPasswordEncoder passwordEncoder;
   private final AppUserRepository appUserRepository;
    private final ConfirmationTokenService confirmationTokenService;

    public void AppUserTest(){
     //applicationUserService = new ApplicationUserService(appUserRepository, passwordEncoder, confirmationTokenService);
    }

    @Test
    public void addHostUser(){
        ApplicationUser appUser = new ApplicationUser(
                "hjec3432@gmail.com",
                passwordEncoder.encode("123456"),
                "hosting",
                ApplicationUserRole.HOST);

        applicationUserService.signUpUser(
               appUser


        );

        applicationUserService.enableAppUser(appUser.getEmail());
    }

    @Test
    public void getGrantedAuthorities(){

//        BCryptPasswordEncoder passwordEncoder;
//        AppUserRepository appUserRepository;
//        ConfirmationTokenService confirmationTokenService;

//        ApplicationUserService applicationUserService
//                = new ApplicationUserService(appUserRepository, passwordEncoder, confirmationTokenService);// = new A


//        UserDetails user = applicationUserService.loadUserByUsername("hjec3432@gmail.com");
//
//        System.out.println("user = " + user);
        
    }
}
