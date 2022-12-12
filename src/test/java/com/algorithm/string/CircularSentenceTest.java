package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircularSentenceTest {

    @Test
    public void isCircularSentence() {
        CircularSentence service = new CircularSentence();
        assertFalse(service.isCircularSentence("leetcode"));
        assertFalse(service.isCircularSentence("Leetcode is cool"));
        assertTrue(service.isCircularSentence("leetcode exercises sound delightful"));
        assertTrue(service.isCircularSentence("eetcode"));
        CircularSentence.StreamSolution streamSolution = new CircularSentence.StreamSolution();
        assertFalse(streamSolution.isCircularSentence("leetcode"));
        assertFalse(streamSolution.isCircularSentence("Leetcode is cool"));
        assertTrue(streamSolution.isCircularSentence("leetcode exercises sound delightful"));
        assertTrue(streamSolution.isCircularSentence("eetcode"));
    }
}