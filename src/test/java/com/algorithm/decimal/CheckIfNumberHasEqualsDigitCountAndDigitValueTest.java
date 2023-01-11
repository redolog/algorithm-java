package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfNumberHasEqualsDigitCountAndDigitValueTest {

    @Test
    public void digitCount() {
        CheckIfNumberHasEqualsDigitCountAndDigitValue service = new CheckIfNumberHasEqualsDigitCountAndDigitValue();
        assertTrue(service.digitCount("1210"));
        assertFalse(service.digitCount("030"));
    }
}