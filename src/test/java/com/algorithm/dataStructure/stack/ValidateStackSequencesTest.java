package com.algorithm.dataStructure.stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidateStackSequencesTest {

    ValidateStackSequences service = new ValidateStackSequences();

    @Test
    public void validateStackSequences() {

        Assert.assertTrue(service.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        Assert.assertFalse(service.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}