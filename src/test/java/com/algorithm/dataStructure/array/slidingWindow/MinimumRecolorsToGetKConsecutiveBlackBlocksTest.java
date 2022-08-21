package com.algorithm.dataStructure.array.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumRecolorsToGetKConsecutiveBlackBlocksTest {

    @Test
    public void minimumRecolors() {
        MinimumRecolorsToGetKConsecutiveBlackBlocks service = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        assertEquals(3, service.minimumRecolors("WBBWWBBWBW", 7));
        assertEquals(0, service.minimumRecolors("WBWBBBW", 2));
    }
}