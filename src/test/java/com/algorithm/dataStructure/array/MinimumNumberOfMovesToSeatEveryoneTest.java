package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumNumberOfMovesToSeatEveryoneTest {

    @Test
    public void minMovesToSeat() {
        MinimumNumberOfMovesToSeatEveryone service = new MinimumNumberOfMovesToSeatEveryone();
        assertEquals(4, service.minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
        assertEquals(7, service.minMovesToSeat(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}));
        assertEquals(4, service.minMovesToSeat(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}));
    }
}