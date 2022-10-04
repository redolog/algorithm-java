package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumAddToMakeParenthesesValidTest {

    @Test
    public void minAddToMakeValid() {
        MinimumAddToMakeParenthesesValid service = new MinimumAddToMakeParenthesesValid();
        assertEquals(1, service.minAddToMakeValid("())"));
        assertEquals(3, service.minAddToMakeValid("((("));
        assertEquals(4, service.minAddToMakeValid("()))(("));
    }
}