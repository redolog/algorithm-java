package com.algorithm.bsearch;

import org.junit.Test;

import static com.algorithm.bsearch.BSearchFindRepetitionTimes.bsearchFindRepetitionTimes;
import static org.junit.Assert.assertEquals;

public class BSearchFindRepetitionTimesTest {

    @Test
    public void bsearchFindRepetitionTimesTest() {

        assertEquals(bsearchFindRepetitionTimes(new int[]{50, 50, 70, 70, 80, 80}, 50), 2);
        assertEquals(bsearchFindRepetitionTimes(new int[]{50, 50, 50, 70, 70, 80, 80}, 50), 3);
        assertEquals(bsearchFindRepetitionTimes(new int[]{50, 50, 70, 70, 80, 80}, 70), 2);
        assertEquals(bsearchFindRepetitionTimes(new int[]{50, 50, 70, 70, 70, 70, 80, 80}, 70), 4);
        assertEquals(bsearchFindRepetitionTimes(new int[]{50, 50, 70, 70, 80, 80, 80, 80, 80}, 80), 5);
    }
}