package com.algorithm.dataStructure.array.prefix;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindTheScoreOfAllPrefixesOfAnArrayTest {

    @Test
    public void findPrefixScore() {
        FindTheScoreOfAllPrefixesOfAnArray service = new FindTheScoreOfAllPrefixesOfAnArray();
        assertArrayEquals(new long[]{4, 10, 24, 36, 56}, service.findPrefixScore(new int[]{2, 3, 7, 5, 10}));
        assertArrayEquals(new long[]{2, 4, 8, 16, 32, 64}, service.findPrefixScore(new int[]{1, 1, 2, 4, 8, 16}));
    }
}