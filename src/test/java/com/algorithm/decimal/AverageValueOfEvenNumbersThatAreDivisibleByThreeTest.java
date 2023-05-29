package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.*;

public class AverageValueOfEvenNumbersThatAreDivisibleByThreeTest {

    @Test
    public void averageValue() {
        AverageValueOfEvenNumbersThatAreDivisibleByThree.LoopSolution loopSolution = new AverageValueOfEvenNumbersThatAreDivisibleByThree.LoopSolution();
        assertEquals(9, loopSolution.averageValue(new int[]{1, 3, 6, 10, 12, 15}));
        assertEquals(0, loopSolution.averageValue(new int[]{1, 2, 4, 7, 10}));
    }
}