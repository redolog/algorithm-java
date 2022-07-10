package com.algorithm.backtrack;

import com.algorithm.util.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationILcciTest {

    PermutationILcci service = new PermutationILcci();

    @Test
    public void permutation() {

        String[] expecteds = {"qwe", "qew", "wqe", "weq", "ewq", "eqw"};
        String[] actuals = service.permutation("qwe");
        for (String actual : actuals) {
            assertTrue(ArrayUtils.contains(expecteds, actual));
        }
    }
}