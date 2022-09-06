package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSequenceTest {

    @Test
    public void testLongestConsecutiveSequence() {
        LongestConsecutiveSequence.Sort sort = new LongestConsecutiveSequence.Sort();
        assertEquals(4, sort.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        assertEquals(9, sort.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        LongestConsecutiveSequence.Hash hash = new LongestConsecutiveSequence.Hash();
        assertEquals(4, hash.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        assertEquals(9, hash.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

}