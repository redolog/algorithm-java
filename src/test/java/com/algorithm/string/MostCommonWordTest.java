package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MostCommonWordTest {

    @Test
    public void mostCommonWord() {
        MostCommonWord service = new MostCommonWord();
        assertEquals("ball", service.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        assertEquals("b", service.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }
}