package com.see0gan.demo.auth;

import com.see0gan.demo.exception.InvalidTypeException;
import com.see0gan.demo.registration.token.ConfirmationToken;
import com.see0gan.demo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    @Qualifier("userRepository")
    private final AppUserRepository appUserRepository;
    @Qualifier("test")
    private final ApplicationUserDao applicationUserDao;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            ApplicationUser user =    appUserRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));

            user.setGrantedAuthorities(user.getApplicationUserRole().getGrantedAuthorities());

        return user;
//       return          applicationUserDao.selectApplicationUserByUsername("Amy").get();



    }


    public String signUpUser(ApplicationUser appUser){

        boolean userExists = appUserRepository.findByEmail(appUser.getUsername())
                                            .isPresent();

        if(userExists){

            throw new InvalidTypeException("email already taken");
        }

        String encodedPassword = passwordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String generatedToken = UUID.randomUUID().toString();

        ConfirmationToken token = new ConfirmationToken(
                generatedToken,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                appUser
        );

        confirmationTokenService.saveConfirmationToken(token);

        return token.getToken();
    }

    public void enableAppUser(String email) {
        ApplicationUser appUser = appUserRepository.findByEmail(email).get();

        appUser.setEnabled(true);
        appUser.setAccountNonExpired(true);
        appUser.setAccountNonLocked(true);
        appUser.setCredentialsNonExpired(true);

        appUserRepository.save(appUser);

    }
}
