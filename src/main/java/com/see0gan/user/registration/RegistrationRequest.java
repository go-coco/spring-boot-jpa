package com.see0gan.user.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationRequest {

    private String email;
    private String password;
    private String name;
}
