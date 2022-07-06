package com.algorithm.lookup.bsearch.bsearch;

import org.junit.Test;

import static com.algorithm.lookup.bsearch.bsearch.BSearchFindUnique.bsearchFindUnique;
import static org.junit.Assert.assertEquals;

public class BSearchFindUniqueTest {

    @Test
    public void bsearchFindUniqueTest() {
        assertEquals(bsearchFindUnique(new int[]{50, 70, 70, 80, 80}), 50);
        assertEquals(bsearchFindUnique(new int[]{70, 70, 80, 80, 100}), 100);
        assertEquals(bsearchFindUnique(new int[]{50, 50, 60, 70, 70, 80, 80}), 60);
        assertEquals(bsearchFindUnique(new int[]{50, 50, 70, 70, 80, 80, 90, 100, 100}), 90);
    }
}