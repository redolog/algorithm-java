package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreeDivisorsTest {

    @Test
    public void isThree() {
        ThreeDivisors service = new ThreeDivisors();
        assertFalse(service.isThree(2));
        assertTrue(service.isThree(4));
    }
}