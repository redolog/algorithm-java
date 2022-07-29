package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestCompletingWordTest {

    @Test
    public void shortestCompletingWord() {
        ShortestCompletingWord service = new ShortestCompletingWord();
        assertEquals("steps", service.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        assertEquals("pest", service.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}