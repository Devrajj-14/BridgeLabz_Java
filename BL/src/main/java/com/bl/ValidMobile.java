package com.bl;

import java.util.regex.Pattern;

public class ValidMobile {
    private static final Pattern PATTERN = Pattern.compile("^[0-9]{2}\\s[0-9]{10}$");

    public boolean validate(String mobile) {
        return mobile != null && PATTERN.matcher(mobile).matches();
    }
}