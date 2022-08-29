package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ShuffleTheArrayTest {

    @Test
    public void shuffle() {
        ShuffleTheArray service = new ShuffleTheArray();
        assertArrayEquals(new int[]{2, 3, 5, 4, 1, 7}, service.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3));
        assertArrayEquals(new int[]{1, 4, 2, 3, 3, 2, 4, 1}, service.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4));
        assertArrayEquals(new int[]{1, 2, 1, 2}, service.shuffle(new int[]{1, 1, 2, 2}, 2));
        ShuffleTheArray.BitInplace bitInplace = new ShuffleTheArray.BitInplace();
        assertArrayEquals(new int[]{2, 3, 5, 4, 1, 7}, bitInplace.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3));
        assertArrayEquals(new int[]{1, 4, 2, 3, 3, 2, 4, 1}, bitInplace.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4));
        assertArrayEquals(new int[]{1, 2, 1, 2}, bitInplace.shuffle(new int[]{1, 1, 2, 2}, 2));
    }
}