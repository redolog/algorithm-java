package com.algorithm.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class MostFrequentEvenElementTest {

    @Test
    public void mostFrequentEven() {
        MostFrequentEvenElement service = new MostFrequentEvenElement();
        assertEquals(2, service.mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));
        assertEquals(4, service.mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4}));
        assertEquals(-1, service.mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
    }
}