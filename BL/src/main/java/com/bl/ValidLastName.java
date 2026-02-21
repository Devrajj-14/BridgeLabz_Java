package com.bl;

import java.util.regex.Pattern;

public class ValidLastName {
    // Starts with capital, min 3 chars, only letters
    private static final Pattern PATTERN = Pattern.compile("^[A-Z][a-zA-Z]{2,}$");

    public boolean validate(String lastName) {
        return lastName != null && PATTERN.matcher(lastName).matches();
    }
}