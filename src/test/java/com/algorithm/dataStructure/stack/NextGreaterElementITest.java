package com.algorithm.dataStructure.stack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextGreaterElementITest {

    @Test
    public void nextGreaterElement() {
        NextGreaterElementI service = new NextGreaterElementI();
        assertArrayEquals(new int[]{-1, 3, -1}, service.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        assertArrayEquals(new int[]{3, -1}, service.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
    }
}