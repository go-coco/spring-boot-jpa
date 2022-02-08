package com.see0gan.demo.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);

    }

    public ConfirmationToken getToken(String token){
        return confirmationTokenRepository.findByToken(token)
                .orElseThrow(() -> new NoSuchElementException("token not found"));
    }

    public void setConfirmedAt(String token) {
        ConfirmationToken foundToken = confirmationTokenRepository.findByToken(token)
                                            .orElseThrow(() -> new NoSuchElementException("no token found"));

        foundToken.setConfirmedAt(LocalDateTime.now());

        confirmationTokenRepository.save(foundToken);
    }
}
