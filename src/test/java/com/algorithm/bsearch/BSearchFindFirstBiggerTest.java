package com.algorithm.bsearch;

import junit.framework.TestCase;

import static com.algorithm.bsearch.BSearchFindFirstBigger.bsearchFindFirstBigger;

public class BSearchFindFirstBiggerTest extends TestCase {

    public void testBsearchFindFirstBigger() {
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 1), 0);
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 2), 2);
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 3), 3);
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 4), 4);
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 5), 5);
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 6), 6);
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 7), 7);
        assertEquals(bsearchFindFirstBigger(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 8), 11);
    }
}