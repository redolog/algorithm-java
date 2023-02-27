package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecreaseElementsToMakeArrayZigzagTest {

    @Test
    public void movesToMakeZigzag() {
        DecreaseElementsToMakeArrayZigzag service = new DecreaseElementsToMakeArrayZigzag();
        assertEquals(2, service.movesToMakeZigzag(new int[]{1, 2, 3}));
        assertEquals(4, service.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
        assertEquals(13, service.movesToMakeZigzag(new int[]{10, 4, 4, 10, 10, 6, 2, 3}));
    }
}