package com.bl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidFirstNameTest {

    @Test
    void givenFirstName_WhenValid_ShouldReturnTrue() {
        ValidFirstName validator = new ValidFirstName();
        Assertions.assertTrue(validator.validate("Devraj"));
    }

    @Test
    void givenFirstName_WhenNotStartingWithCap_ShouldReturnFalse() {
        ValidFirstName validator = new ValidFirstName();
        Assertions.assertFalse(validator.validate("devraj"));
    }

    @Test
    void givenFirstName_WhenLessThan3Chars_ShouldReturnFalse() {
        ValidFirstName validator = new ValidFirstName();
        Assertions.assertFalse(validator.validate("De"));
    }

    @Test
    void givenFirstName_WhenContainsNumber_ShouldReturnFalse() {
        ValidFirstName validator = new ValidFirstName();
        Assertions.assertFalse(validator.validate("De1"));
    }
}