package com.see0gan.user.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;

    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest request){

        return registrationService.register(request);
    }

    @GetMapping(path="/confirm")
    public String activateUser(@RequestParam("token") String token){
        return registrationService.confirmToken(token);

    }
}
