package com.algorithm.bsearch;

import junit.framework.TestCase;

import static com.algorithm.bsearch.BSearchFindLastSmallerOrEqual.bsearchFindLastSmallerOrEqual;


public class BSearchFindLastSmallerOrEqualTest extends TestCase {

    public void testBsearchFindFirstSmallerOrEqual() {
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 1), 1);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 2), 2);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 3), 3);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 4), 4);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 5), 5);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 6), 6);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 7), 10);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 8), 11);
        assertEquals(bsearchFindLastSmallerOrEqual(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8}, 0), -1);

    }
}