package com.algorithm.bsearch;

import org.junit.Test;

import static com.algorithm.bsearch.BSearch.bsearch;
import static com.algorithm.bsearch.BSearch.bsearchRecursive;
import static org.junit.Assert.assertEquals;

public class BSearchTest {

    @Test
    public void bsearchTest() {
        assertEquals(bsearch(new int[]{50, 70, 70, 80, 80}, 50), 50);
        assertEquals(bsearch(new int[]{70, 70, 80, 80, 100}, 80), 80);
        assertEquals(bsearch(new int[]{50, 50, 60, 70, 70, 80, 80}, 80), 80);
        assertEquals(bsearch(new int[]{50, 50, 70, 70, 80, 80, 90, 100, 100}, 70), 70);

        assertEquals(bsearchRecursive(new int[]{50, 70, 70, 80, 80}, 50), 50);
        assertEquals(bsearchRecursive(new int[]{70, 70, 80, 80, 100}, 80), 80);
        assertEquals(bsearchRecursive(new int[]{50, 50, 60, 70, 70, 80, 80}, 80), 80);
        assertEquals(bsearchRecursive(new int[]{50, 50, 70, 70, 80, 80, 90, 100, 100}, 70), 70);
    }
}