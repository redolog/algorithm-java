package com.algorithm.bsearch;

import junit.framework.TestCase;

import static com.algorithm.bsearch.BSearchFindFirstBiggerOrEqual.bsearchFindFirstBiggerOrEqual;

public class BSearchFindFirstBiggerOrEqualTest extends TestCase {

    public void testBsearchFindFirstBiggerOrEqual() {
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 1), 0);
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 2), 2);
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 3), 3);
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 4), 4);
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 5), 5);
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 6), 6);
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 7), 7);
        assertEquals(bsearchFindFirstBiggerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 8), 11);
    }
}