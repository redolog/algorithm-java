package com.algorithm.string.subString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TruncateSentenceTest {

    @Test
    public void truncateSentence() {
        TruncateSentence service = new TruncateSentence();
        assertEquals("Hello how are you", service.truncateSentence("Hello how are you Contestant", 4));
        assertEquals("What is the solution", service.truncateSentence("What is the solution to this problem", 4));
        assertEquals("chopper is not a tanuki", service.truncateSentence("chopper is not a tanuki", 5));
    }
}