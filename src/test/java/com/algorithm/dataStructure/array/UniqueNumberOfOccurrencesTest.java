package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueNumberOfOccurrencesTest {

    @Test
    public void uniqueOccurrences() {
        UniqueNumberOfOccurrences service = new UniqueNumberOfOccurrences();
        assertTrue(service.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        assertTrue(service.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        assertFalse(service.uniqueOccurrences(new int[]{1, 2}));
    }
}