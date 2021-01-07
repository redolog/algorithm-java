package com.algorithm.dataStructure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {

    ValidParentheses service;

    @Before
    public void setUp() throws Exception {
        service = new ValidParentheses();
    }

    @Test
    public void isValid() {

        assertTrue(service.isValid("{}"));
        assertFalse(service.isValid("{|}"));
    }
}