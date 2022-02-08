package com.see0gan.demo.auth;

import com.google.common.collect.Lists;
import com.see0gan.demo.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.see0gan.demo.security.ApplicationUserRole.*;

@Repository("test")
public class ApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "amy.smith@posco.com",
                        passwordEncoder.encode("password"),
                        "Amy",
                        ApplicationUserRole.GUEST,
                        true,
                        true,
                        true,
                        true
                )
                ,  new ApplicationUser(
                        "grace.kim@samsung.com",
                        passwordEncoder.encode("password123"),
                        "Grace",
                        HOST,
                        true,
                        true,
                        true,
                        true
                )

        );

        return applicationUsers;
    }


}
