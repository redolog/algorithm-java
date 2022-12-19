package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddDigitsTest {

    @Test
    public void addDigits() {
        AddDigits.Iteration iteration = new AddDigits.Iteration();
        assertEquals(0, iteration.addDigits(0));
        assertEquals(2, iteration.addDigits(38));
        AddDigits.Math math = new AddDigits.Math();
        assertEquals(0, math.addDigits(0));
        assertEquals(2, math.addDigits(38));
    }
}