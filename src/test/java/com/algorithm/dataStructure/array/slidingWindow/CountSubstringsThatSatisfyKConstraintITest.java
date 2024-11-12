package com.algorithm.dataStructure.array.slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountSubstringsThatSatisfyKConstraintITest {

    @Test
    public void countKConstraintSubstrings() {
        CountSubstringsThatSatisfyKConstraintI service = new CountSubstringsThatSatisfyKConstraintI();
        assertEquals(12, service.countKConstraintSubstrings("10101", 1));
        assertEquals(25, service.countKConstraintSubstrings("1010101", 2));
        assertEquals(15, service.countKConstraintSubstrings("11111", 1));
    }
}