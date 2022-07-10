package com.algorithm.backtrack;

import com.algorithm.util.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringPermutationTest {

    StringPermutation service = new StringPermutation();

    @Test
    public void permutation() {
        String[] expecteds = {"abc", "acb", "bac", "bca", "cab", "cba"};
        String[] actuals = service.permutation("abc");
        for (String actual : actuals) {
            assertTrue(ArrayUtils.contains(expecteds, actual));
        }
    }
}