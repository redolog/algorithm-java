package com.algorithm.dataStructure.array.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinMaxGameTest {

    @Test
    public void minMaxGame() {
        MinMaxGame.RecursionSolution recursionSolution = new MinMaxGame.RecursionSolution();
        assertEquals(1, recursionSolution.minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        assertEquals(3, recursionSolution.minMaxGame(new int[]{3}));
        MinMaxGame.LoopSolution loopSolution = new MinMaxGame.LoopSolution();
        assertEquals(1, loopSolution.minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        assertEquals(3, loopSolution.minMaxGame(new int[]{3}));
    }
}