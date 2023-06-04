package com.algorithm.dataStructure.array.app.sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfDistinctAveragesTest {

    @Test
    public void distinctAverages() {
        NumberOfDistinctAverages service = new NumberOfDistinctAverages();
        assertEquals(2, service.distinctAverages(new int[]{4, 1, 4, 0, 3, 5}));
        assertEquals(1, service.distinctAverages(new int[]{1, 100}));
        assertEquals(5, service.distinctAverages(new int[]{9, 5, 7, 8, 7, 9, 8, 2, 0, 7}));
    }
}