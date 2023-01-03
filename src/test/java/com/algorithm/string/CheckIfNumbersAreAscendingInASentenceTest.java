package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfNumbersAreAscendingInASentenceTest {

    @Test
    public void areNumbersAscending() {
        CheckIfNumbersAreAscendingInASentence.LoopSolution loopSolution = new CheckIfNumbersAreAscendingInASentence.LoopSolution();
        assertTrue(loopSolution.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        assertFalse(loopSolution.areNumbersAscending("hello world 5 x 5"));
        assertFalse(loopSolution.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        CheckIfNumbersAreAscendingInASentence.StreamSolution streamSolution = new CheckIfNumbersAreAscendingInASentence.StreamSolution();
        assertTrue(streamSolution.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        assertFalse(streamSolution.areNumbersAscending("hello world 5 x 5"));
        assertFalse(streamSolution.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
    }
}