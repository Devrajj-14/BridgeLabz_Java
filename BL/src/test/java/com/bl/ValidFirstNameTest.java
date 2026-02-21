package com.bl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidFirstNameTest {

    @Test
    void shouldReturnTrueForValidFirstName() {
        Assertions.assertTrue(ValidFirstName.check("Devraj"));
    }

    @Test
    void shouldReturnFalseIfFirstLetterNotCapital() {
        assertFalse(ValidFirstName.check("devraj"));
    }

    @Test
    void shouldReturnFalseIfTooShort() {
        assertFalse(ValidFirstName.check("De"));
    }

    @Test
    void shouldReturnFalseIfContainsNonLetters() {
        assertFalse(ValidFirstName.check("Devraj1"));
        assertFalse(ValidFirstName.check("Dev_raj"));
    }
}