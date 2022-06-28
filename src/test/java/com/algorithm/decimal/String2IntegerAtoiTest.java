package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class String2IntegerAtoiTest {

    @Test
    public void myAtoi() {
        String2IntegerAtoi service = new String2IntegerAtoi();
        assertEquals(42, service.myAtoi("42"));
        assertEquals(-42, service.myAtoi("-42"));
        assertEquals(2147483647, service.myAtoi("2147483647"));
        assertEquals(-2147483648, service.myAtoi("-2147483648"));
        assertEquals(0, service.myAtoi("+-12"));
        assertEquals(0, service.myAtoi("00000-42a1234"));
        assertEquals(3, service.myAtoi("3.14159"));
        assertEquals(-12, service.myAtoi("  -0012a42"));
        assertEquals(0, service.myAtoi(""));
    }
}