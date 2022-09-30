package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PerfectNumberTest {

    @Test
    public void checkPerfectNumber() {
        PerfectNumber service = new PerfectNumber();
        assertTrue(service.checkPerfectNumber(28));
        assertFalse(service.checkPerfectNumber(7));
        assertFalse(service.checkPerfectNumber(1));
        assertFalse(service.checkPerfectNumber(2));
    }
}