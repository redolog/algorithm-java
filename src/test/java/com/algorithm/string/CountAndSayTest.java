package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountAndSayTest {

    @Test
    public void countAndSay() {
        CountAndSay.RecursionSolution recursionSolution = new CountAndSay.RecursionSolution();
        assertEquals("1", recursionSolution.countAndSay(1));
        assertEquals("1211", recursionSolution.countAndSay(4));
        CountAndSay.IterationSolution iterationSolution = new CountAndSay.IterationSolution();
        assertEquals("1", iterationSolution.countAndSay(1));
        assertEquals("1211", iterationSolution.countAndSay(4));
    }
}