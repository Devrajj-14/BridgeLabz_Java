package com.bl;

import java.util.regex.Pattern;

public class ValidEmail {
    // local: abc OR abc.xyz
    // domain: bl.co OR bl.co.in
    private static final Pattern PATTERN =
            Pattern.compile("^[a-z]+(\\.[a-z]+)?@bl\\.co(\\.in)?$");

    public boolean validate(String email) {
        return email != null && PATTERN.matcher(email).matches();
    }
}