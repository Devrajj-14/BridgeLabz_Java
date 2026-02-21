package com.bl;

public class ValidNametwo {
    public static boolean check(String s) {
        return s != null && s.matches("^[A-Z][a-z]{2,}$");
    }
}