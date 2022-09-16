package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoatsToSavePeopleTest {

    @Test
    public void numRescueBoats() {
        BoatsToSavePeople service = new BoatsToSavePeople();
        assertEquals(1, service.numRescueBoats(new int[]{1, 2}, 3));
        assertEquals(3, service.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        assertEquals(4, service.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        assertEquals(2, service.numRescueBoats(new int[]{5, 1, 4, 2}, 6));
    }
}