package com.algorithm.dataStructure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicCalculatorTest {

    BasicCalculator service;

    @Before
    public void setUp() throws Exception {
        service = new BasicCalculator();
    }

    @Test
    public void calculate() {
        assertEquals(2, service.calculate("1 + 1"));
        assertEquals(3, service.calculate("2-1 + 2 "));
        assertEquals(23, service.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}