package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursiveMultiplyLcciTest {

    @Test
    public void multiply() {
        RecursiveMultiplyLcci.Traversal traversal = new RecursiveMultiplyLcci.Traversal();
        assertEquals(12, traversal.multiply(3, 4));
        assertEquals(10, traversal.multiply(1, 10));
        RecursiveMultiplyLcci.Recursion recursion = new RecursiveMultiplyLcci.Recursion();
        assertEquals(12, recursion.multiply(3, 4));
        assertEquals(10, recursion.multiply(1, 10));
    }
}