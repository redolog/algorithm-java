package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberComplementTest {

    @Test
    public void findComplement() {
        NumberComplement service = new NumberComplement();
        assertEquals(2, service.findComplement(5));
        assertEquals(0, service.findComplement(1));
    }
}