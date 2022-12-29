package com.algorithm.dataStructure.array;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class TwoOutOfThreeTest {

    @Test
    public void twoOutOfThree() {
        TwoOutOfThree.SetSolution setSolution = new TwoOutOfThree.SetSolution();
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3), setSolution.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3})));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3, 1), setSolution.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), setSolution.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5})));
        TwoOutOfThree.BitSolution bitSolution = new TwoOutOfThree.BitSolution();
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3), bitSolution.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3})));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3, 1), bitSolution.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), bitSolution.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5})));
    }
}