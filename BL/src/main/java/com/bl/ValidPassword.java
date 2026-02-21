package com.bl;

public class ValidPassword {

    public boolean validate(String password) {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasDigit = false;
        int specialCount = 0;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetter(ch)) specialCount++; // counts any non-letter (including spaces)
        }

        // If you don't want space to be treated as special char, add: if (Character.isWhitespace(ch)) return false;
        return hasUpper && hasDigit && specialCount == 1;
    }
}