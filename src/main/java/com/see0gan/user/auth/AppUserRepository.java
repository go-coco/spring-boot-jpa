package com.see0gan.user.auth;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository("userRepository")
public interface AppUserRepository extends JpaRepository<ApplicationUser, Long>{

    Optional<ApplicationUser> findByEmail(String email);


}
