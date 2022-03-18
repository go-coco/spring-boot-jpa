package com.see0gan.demo.auth;

import com.see0gan.demo.security.ApplicationUserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class ApplicationUser implements UserDetails {


    @Id
    @SequenceGenerator(
            name = "app_user_id"
            , sequenceName = "app_user_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_id"
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    private ApplicationUserRole applicationUserRole;
    @Transient
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private String name;
    private String password;
    private String email;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public ApplicationUser(String email,
                           String password,
                           String name,
                           ApplicationUserRole userRole) {
        this.applicationUserRole = userRole;
        this.password = password;
        this.email = email;
        this.name = name;
    }



    public ApplicationUser(String email,
                           String password,
                           String name,
                           ApplicationUserRole userRole,
                           boolean isAccountNonExpired,
                           boolean isAccountNonLocked,
                           boolean isCredentialsNonExpired,
                           boolean isEnabled) {
        this.applicationUserRole = userRole;
        this.password = password;
        this.email = email;
        this.name = name;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }



    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){ this.password = password; }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
