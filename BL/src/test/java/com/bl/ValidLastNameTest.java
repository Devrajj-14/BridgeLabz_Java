package com.bl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidLastNameTest {

    @Test
    void givenLastName_WhenValid_ShouldReturnTrue() {
        ValidLastName validator = new ValidLastName();
        Assertions.assertTrue(validator.validate("Kumar"));
    }

    @Test
    void givenLastName_WhenNotStartingWithCap_ShouldReturnFalse() {
        ValidLastName validator = new ValidLastName();
        Assertions.assertFalse(validator.validate("kumar"));
    }

    @Test
    void givenLastName_WhenLessThan3Chars_ShouldReturnFalse() {
        ValidLastName validator = new ValidLastName();
        Assertions.assertFalse(validator.validate("Ku"));
    }

    @Test
    void givenLastName_WhenContainsSpecialChar_ShouldReturnFalse() {
        ValidLastName validator = new ValidLastName();
        Assertions.assertFalse(validator.validate("Ku@"));
    }
}