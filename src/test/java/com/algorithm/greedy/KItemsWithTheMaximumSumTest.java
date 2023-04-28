package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class KItemsWithTheMaximumSumTest {

    @Test
    public void kItemsWithMaximumSum() {
        KItemsWithTheMaximumSum.SimulationSolution simulationSolution = new KItemsWithTheMaximumSum.SimulationSolution();
        assertEquals(2, simulationSolution.kItemsWithMaximumSum(3, 2, 0, 2));
        assertEquals(3, simulationSolution.kItemsWithMaximumSum(3, 2, 0, 4));
        KItemsWithTheMaximumSum.MathSolution mathSolution = new KItemsWithTheMaximumSum.MathSolution();
        assertEquals(2, mathSolution.kItemsWithMaximumSum(3, 2, 0, 2));
        assertEquals(3, mathSolution.kItemsWithMaximumSum(3, 2, 0, 4));
    }
}