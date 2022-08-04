package com.algorithm.dataStructure.array.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindContinuousSequenceTest {

    @Test
    public void findContinuousSequence() {
        FindContinuousSequence service = new FindContinuousSequence();
        assertArrayEquals(new int[][]{{2, 3, 4}, {4, 5}}, service.findContinuousSequence(9));
        assertArrayEquals(new int[][]{{1, 2, 3, 4, 5}, {4, 5, 6}, {7, 8}}, service.findContinuousSequence(15));
    }
}