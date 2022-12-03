package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecondLargestDigitInAStringTest {

    @Test
    public void secondHighest() {
        SecondLargestDigitInAString.LoopOnce loopOnce = new SecondLargestDigitInAString.LoopOnce();
        assertEquals(2, loopOnce.secondHighest("dfa12321afd"));
        assertEquals(-1, loopOnce.secondHighest("abc1111"));
        SecondLargestDigitInAString.LoopTwice loopTwice = new SecondLargestDigitInAString.LoopTwice();
        assertEquals(2, loopTwice.secondHighest("dfa12321afd"));
        assertEquals(-1, loopTwice.secondHighest("abc1111"));
    }
}