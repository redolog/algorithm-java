package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertANumber2HexadecimalTest {

    @Test
    public void toHex() {
        ConvertANumber2Hexadecimal service = new ConvertANumber2Hexadecimal();

        assertEquals("1a", service.toHex(26));
        assertEquals("ffffffff", service.toHex(-1));
        assertEquals("1a", service.toHex(26));
    }
}