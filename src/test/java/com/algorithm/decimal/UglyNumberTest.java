package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UglyNumberTest {

    @Test
    public void isUgly() {
        UglyNumber service = new UglyNumber();
        assertTrue(service.isUgly(6));
        assertTrue(service.isUgly(1));
        assertFalse(service.isUgly(14));
        assertTrue(service.isUgly2(6));
        assertTrue(service.isUgly2(1));
        assertFalse(service.isUgly2(14));
    }
}