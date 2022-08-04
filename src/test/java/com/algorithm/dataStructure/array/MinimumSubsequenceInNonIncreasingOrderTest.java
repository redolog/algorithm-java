package com.algorithm.dataStructure.array;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class MinimumSubsequenceInNonIncreasingOrderTest {

    @Test
    public void minSubsequence() {
        MinimumSubsequenceInNonIncreasingOrder service = new MinimumSubsequenceInNonIncreasingOrder();
        assertTrue(CollectionUtils.equals(Arrays.asList(10, 9), service.minSubsequence(new int[]{4, 3, 10, 9, 8})));
        assertTrue(CollectionUtils.equals(Arrays.asList(7, 7, 6), service.minSubsequence(new int[]{4, 4, 7, 6, 7})));
        assertTrue(CollectionUtils.equals(Collections.singletonList(6), service.minSubsequence(new int[]{6})));
    }
}