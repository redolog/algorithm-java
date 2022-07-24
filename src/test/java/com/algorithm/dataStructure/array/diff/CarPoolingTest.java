package com.algorithm.dataStructure.array.diff;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarPoolingTest {

    @Test
    public void testCarPooling() {
        CarPooling.DiffArr diffArr = new CarPooling.DiffArr();
        assertFalse(diffArr.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        assertTrue(diffArr.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }

}