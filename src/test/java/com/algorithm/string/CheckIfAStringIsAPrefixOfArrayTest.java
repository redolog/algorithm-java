package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckIfAStringIsAPrefixOfArrayTest {

    @Test
    public void isPrefixString() {
        CheckIfAStringIsAPrefixOfArray service = new CheckIfAStringIsAPrefixOfArray();
        assertTrue(service.isPrefixString("iloveleetcode", new String[]{"i", "love", "leetcode", "apples"}));
        assertFalse(service.isPrefixString("iloveleetcode", new String[]{"apples", "i", "love", "leetcode"}));
        assertFalse(service.isPrefixString("a", new String[]{"aa", "aaaa", "banana"}));
    }
}