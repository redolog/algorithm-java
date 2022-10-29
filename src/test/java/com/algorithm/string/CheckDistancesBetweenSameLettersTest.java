package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckDistancesBetweenSameLettersTest {

    @Test
    public void checkDistances() {
        CheckDistancesBetweenSameLetters.MapSolution mapSolution = new CheckDistancesBetweenSameLetters.MapSolution();
        assertTrue(mapSolution.checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertFalse(mapSolution.checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        CheckDistancesBetweenSameLetters.ArrSolution arrSolution = new CheckDistancesBetweenSameLetters.ArrSolution();
        assertTrue(arrSolution.checkDistances("abaccb", new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertFalse(arrSolution.checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}