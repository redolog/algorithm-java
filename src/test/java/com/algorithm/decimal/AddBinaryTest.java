package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBinaryTest {

    @Test
    public void addBinary() {
        AddBinary service = new AddBinary();
        assertEquals("100", service.addBinary("11", "1"));
        assertEquals("10101", service.addBinary("1010", "1011"));
    }
}