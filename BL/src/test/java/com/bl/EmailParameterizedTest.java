package com.bl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class EmailParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.au",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc+100@gmail.com",
            "abc.xyz@bl.co.in"
    })
    void givenEmails_WhenValid_ShouldReturnTrue(String email) {
        ValidEmail validator = new ValidEmail();
        Assertions.assertTrue(validator.validate(email), "Should be valid: " + email);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    void givenEmails_WhenInvalid_ShouldReturnFalse(String email) {
        ValidEmail validator = new ValidEmail();
        Assertions.assertFalse(validator.validate(email), "Should be invalid: " + email);
    }

    // If you want in one table: email + expected result
    @ParameterizedTest
    @CsvSource({
            "abc.xyz@bl.co.in,true",
            "abc@yahoo.com,true",
            "abc@.com.my,false",
            "abc,false"
    })
    void givenEmails_WhenChecked_ShouldMatchExpected(String email, boolean expected) {
        ValidEmail validator = new ValidEmail();
        Assertions.assertEquals(expected, validator.validate(email));
    }
}