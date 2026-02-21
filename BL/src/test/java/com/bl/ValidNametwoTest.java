package com.bl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidNametwoTest {

    @Test
    void userInputShouldBeValidFirstName() {
        String input = System.getProperty("firstNameUnderTest");
        assertNotNull(input, "No input passed from runner");
        assertTrue(ValidNametwo.check(input),
                "Input '" + input + "' is NOT a valid first name");
    }

    @Test
    void lowercaseShouldFail() {
        assertFalse(ValidNametwo.check("devraj"));
    }

    @Test
    void tooShortShouldFail() {
        assertFalse(ValidNametwo.check("De"));
    }

    @Test
    void nonLettersShouldFail() {
        assertFalse(ValidNametwo.check("Devraj1"));
    }
}