package com.bl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailValidationTest {

    @Test
    void givenEmail_WhenValid_ShouldReturnTrue() {
        ValidEmail validator = new ValidEmail();
        Assertions.assertTrue(validator.validate("abc.xyz@bl.co.in"));
    }

    @Test
    void givenEmail_WhenMissingAt_ShouldReturnFalse() {
        ValidEmail validator = new ValidEmail();
        Assertions.assertFalse(validator.validate("abc.xyzbl.co.in"));
    }

    @Test
    void givenEmail_WhenWrongDotPositions_ShouldReturnFalse() {
        ValidEmail validator = new ValidEmail();
        Assertions.assertFalse(validator.validate("abc@bl..co.in"));
    }

    @Test
    void givenEmail_WhenMissingMandatoryParts_ShouldReturnFalse() {
        ValidEmail validator = new ValidEmail();
        Assertions.assertFalse(validator.validate("abc@co.in"));
    }
}