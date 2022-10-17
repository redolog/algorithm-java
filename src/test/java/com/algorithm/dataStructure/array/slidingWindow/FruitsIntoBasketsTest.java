package com.algorithm.dataStructure.array.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FruitsIntoBasketsTest {

    @Test
    public void totalFruit() {
        FruitsIntoBaskets service = new FruitsIntoBaskets();
        assertEquals(3, service.totalFruit(new int[]{1, 2, 1}));
        assertEquals(3, service.totalFruit(new int[]{0, 1, 2, 2}));
        assertEquals(4, service.totalFruit(new int[]{1, 2, 3, 2, 2}));
        assertEquals(5, service.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        assertEquals(1, service.totalFruit(new int[]{0}));
        assertEquals(5, service.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
    }
}