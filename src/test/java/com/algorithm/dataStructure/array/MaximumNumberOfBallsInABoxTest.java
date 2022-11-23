package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumNumberOfBallsInABoxTest {

    @Test
    public void countBalls() {
        MaximumNumberOfBallsInABox service = new MaximumNumberOfBallsInABox();
        assertEquals(1, service.getBox(1));
        assertEquals(1, service.getBox(10));
        assertEquals(1, service.getBox(100));
        assertEquals(2, service.getBox(101));

        assertEquals(2, service.countBalls(1, 10));
        assertEquals(2, service.countBalls(5, 15));
    }
}