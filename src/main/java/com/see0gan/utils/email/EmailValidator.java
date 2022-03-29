package com.see0gan.utils.email;

import org.checkerframework.checker.regex.qual.Regex;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {

    // reference : https://www.baeldung.com/java-email-validation-regex
    private final static String regPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            //"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    @Override
    public boolean test(String email) {

        return Pattern.compile(regPattern)
                .matcher(email)
                .matches();
    }
}
