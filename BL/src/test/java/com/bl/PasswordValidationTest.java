package com.bl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {

    @Test
    void givenPassword_WhenValid_ShouldReturnTrue() {
        ValidPassword validator = new ValidPassword();
        // min 8, >=1 uppercase, >=1 digit, exactly 1 special char
        Assertions.assertTrue(validator.validate("Abcdefg1@"));
    }

    @Test
    void givenPassword_WhenLessThan8_ShouldReturnFalse() {
        ValidPassword validator = new ValidPassword();
        Assertions.assertFalse(validator.validate("Abc1@"));
    }

    @Test
    void givenPassword_WhenNoUppercase_ShouldReturnFalse() {
        ValidPassword validator = new ValidPassword();
        Assertions.assertFalse(validator.validate("abcdefg1@"));
    }

    @Test
    void givenPassword_WhenNoDigit_ShouldReturnFalse() {
        ValidPassword validator = new ValidPassword();
        Assertions.assertFalse(validator.validate("Abcdefgh@"));
    }

    @Test
    void givenPassword_WhenNoSpecialChar_ShouldReturnFalse() {
        ValidPassword validator = new ValidPassword();
        Assertions.assertFalse(validator.validate("Abcdefg12"));
    }

    @Test
    void givenPassword_WhenMoreThan1SpecialChar_ShouldReturnFalse() {
        ValidPassword validator = new ValidPassword();
        Assertions.assertFalse(validator.validate("Abcdefg1@@"));
    }
}