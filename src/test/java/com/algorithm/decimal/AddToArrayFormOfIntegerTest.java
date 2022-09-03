package com.algorithm.decimal;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class AddToArrayFormOfIntegerTest {

    @Test
    public void addToArrayForm() {
        AddToArrayFormOfInteger service = new AddToArrayFormOfInteger();
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), service.addToArrayForm(new int[]{1, 2, 0, 0}, 34)));
        assertTrue(CollectionUtils.equals(Arrays.asList(4, 5, 5), service.addToArrayForm(new int[]{2, 7, 4}, 181)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 0, 2, 1), service.addToArrayForm(new int[]{2, 1, 5}, 806)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 0, 0, 0, 0), service.addToArrayForm(new int[]{0}, 10000)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), service.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 5, 7, 9), service.addToArrayForm(new int[]{1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3}, 516)));
    }
}