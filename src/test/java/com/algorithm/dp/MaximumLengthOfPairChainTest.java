package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumLengthOfPairChainTest {

    @Test
    public void testMaximumLengthOfPairChain() {
        MaximumLengthOfPairChain.Greedy greedy = new MaximumLengthOfPairChain.Greedy();
        assertEquals(2, greedy.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        assertEquals(3, greedy.findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));
        MaximumLengthOfPairChain.DP dp = new MaximumLengthOfPairChain.DP();
        assertEquals(2, dp.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        assertEquals(3, dp.findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));
    }

}