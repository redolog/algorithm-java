package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfArithmeticTripletsTest {

    @Test
    public void arithmeticTriplets() {
        NumberOfArithmeticTriplets.SetSolution setSolution = new NumberOfArithmeticTriplets.SetSolution();
        assertEquals(2, setSolution.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
        assertEquals(2, setSolution.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
        NumberOfArithmeticTriplets.TriplePointerSolution triplePointerSolution = new NumberOfArithmeticTriplets.TriplePointerSolution();
        assertEquals(2, triplePointerSolution.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
        assertEquals(2, triplePointerSolution.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
    }
}