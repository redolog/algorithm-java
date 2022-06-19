package com.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciSequenceTest {

    FibonacciSequence service = new FibonacciSequence();

    @Test
    public void fib() {

        Assert.assertEquals(1, service.fib(2));
        Assert.assertEquals(5, service.fib(5));
    }
}