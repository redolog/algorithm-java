package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FlippingAnImageTest {

    @Test
    public void flipAndInvertImage() {
        FlippingAnImage service = new FlippingAnImage();
        assertArrayEquals(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}}, service.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
        assertArrayEquals(new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}}, service.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}));
    }
}