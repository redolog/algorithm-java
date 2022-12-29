package com.algorithm.dataStructure.array;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class TwoOutOfThreeTest {

    @Test
    public void twoOutOfThree() {
        TwoOutOfThree service = new TwoOutOfThree();
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3), service.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3})));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3, 1), service.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), service.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5})));
    }
}