package com.bl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MobileValidationTest {

    @Test
    void givenMobile_WhenValid_ShouldReturnTrue() {
        ValidMobile validator = new ValidMobile();
        Assertions.assertTrue(validator.validate("91 9919819801"));
    }

    @Test
    void givenMobile_WhenNoSpaceAfterCountryCode_ShouldReturnFalse() {
        ValidMobile validator = new ValidMobile();
        Assertions.assertFalse(validator.validate("919919819801"));
    }

    @Test
    void givenMobile_WhenLessThan10Digits_ShouldReturnFalse() {
        ValidMobile validator = new ValidMobile();
        Assertions.assertFalse(validator.validate("91 991981980"));
    }

    @Test
    void givenMobile_WhenContainsLetters_ShouldReturnFalse() {
        ValidMobile validator = new ValidMobile();
        Assertions.assertFalse(validator.validate("91 99198A9801"));
    }
}