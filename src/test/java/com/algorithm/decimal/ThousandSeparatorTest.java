package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThousandSeparatorTest {

    @Test
    public void thousandSeparator() {
        ThousandSeparator service = new ThousandSeparator();
        assertEquals("987", service.thousandSeparator(987));
        assertEquals("1.234", service.thousandSeparator(1234));
        assertEquals("123.456.789", service.thousandSeparator(123456789));
        assertEquals("0", service.thousandSeparator(0));
    }
}