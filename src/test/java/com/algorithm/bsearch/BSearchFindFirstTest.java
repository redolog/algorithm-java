package com.algorithm.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class BSearchFindFirstTest {

    @Test
    public void bsearchFindFistTest() {

        Assert.assertEquals(BSearchFindFirst.bsearchFindFirst(new int[]{50, 70, 70, 80, 80, 100}, 80), 3);
        Assert.assertEquals(BSearchFindFirst.bsearchFindFirst(new int[]{50, 70, 70, 80, 80, 100}, 70), 1);
        Assert.assertEquals(BSearchFindFirst.bsearchFindFirst(new int[]{50, 50, 70, 70, 80, 80, 100}, 50), 0);
        Assert.assertEquals(BSearchFindFirst.bsearchFindFirst(new int[]{50, 50, 70, 70, 80, 80, 100, 100}, 100), 6);
    }
}