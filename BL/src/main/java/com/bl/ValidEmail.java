package com.bl;

import java.util.regex.Pattern;

public class ValidEmail {

    private static final Pattern PATTERN = Pattern.compile(
            "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@" +
                    "[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$"
    );

    public boolean validate(String email) {
        return email != null && PATTERN.matcher(email).matches();
    }
}