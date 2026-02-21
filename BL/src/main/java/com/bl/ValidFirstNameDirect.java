package com.bl;

import java.util.Scanner;

public class ValidFirstNameDirect {

    public static boolean check(String s) {
        return s != null && s.matches("^[A-Z][a-z]{2,}$");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.next();        // Devraj
            boolean expected = sc.nextBoolean(); // true/false

            boolean actual = check(input);

            if (actual == expected) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL (expected=" + expected + ", actual=" + actual + ")");
            }
        }
    }
}