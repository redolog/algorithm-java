package com.algorithm.decimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestNumberAtLeastTwiceOfOthersTest {

    @Test
    public void dominantIndex() {
        LargestNumberAtLeastTwiceOfOthers service = new LargestNumberAtLeastTwiceOfOthers();
        assertEquals(1, service.dominantIndex(new int[]{3, 6, 1, 0}));
        assertEquals(-1, service.dominantIndex(new int[]{1, 2, 3, 4}));
        assertEquals(0, service.dominantIndex(new int[]{1}));
        assertEquals(1, service.dominantIndex2(new int[]{3, 6, 1, 0}));
        assertEquals(-1, service.dominantIndex2(new int[]{1, 2, 3, 4}));
        assertEquals(0, service.dominantIndex2(new int[]{1}));
    }
}