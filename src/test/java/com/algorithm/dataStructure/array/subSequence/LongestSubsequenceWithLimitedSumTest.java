package com.algorithm.dataStructure.array.subSequence;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LongestSubsequenceWithLimitedSumTest {

    @Test
    public void answerQueries() {
        LongestSubsequenceWithLimitedSum service = new LongestSubsequenceWithLimitedSum();
//        assertArrayEquals(new int[]{2, 3, 4}, service.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}));
        assertArrayEquals(new int[]{0}, service.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1}));
    }
}