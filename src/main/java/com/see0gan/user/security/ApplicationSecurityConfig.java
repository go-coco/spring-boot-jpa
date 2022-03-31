package com.see0gan.user.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.see0gan.user.auth.ApplicationUserService;

import static com.see0gan.user.security.ApplicationUserPermission.SPACE_WRITE;
import static com.see0gan.user.security.ApplicationUserRole.GUEST;
import static com.see0gan.user.security.ApplicationUserRole.HOST;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/hostCenter", "/css/**", "/icon/**", "/join", "/api/v1/registration/**").permitAll()
                .antMatchers( "/space/registration/**").hasRole(HOST.name())
                .antMatchers( "/userprofile/**").hasAnyRole(GUEST.name(), HOST.name())
                .antMatchers("/api/v*/spaces/**").permitAll()
                .antMatchers("/api/v2/hosts/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v*/spaces/**").hasAuthority(SPACE_WRITE.name())
                .antMatchers(HttpMethod.DELETE, "/api/v1/spaces/**").hasAuthority(SPACE_WRITE.name())
                //.antMatchers(HttpMethod.POST, "/api/v*/space/**").hasAuthority(SPACE_WRITE.name())
                .antMatchers(HttpMethod.POST, "/api/v*/spaces/**").permitAll()//hasAuthority(SPACE_WRITE.name())
                
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/", true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(30))
                    .key("securekeywithmeforevergo") // defaults to 2 weeks
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login");
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);

        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
        auth.userDetailsService(applicationUserService);
    }

}
