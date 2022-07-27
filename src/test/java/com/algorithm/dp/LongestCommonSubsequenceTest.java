package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {

    @Test
    public void longestCommonSubsequence() {
        LongestCommonSubsequence service = new LongestCommonSubsequence();
        assertEquals(3, service.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, service.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, service.longestCommonSubsequence("abc", "def"));
        LongestCommonSubsequence.Sentinel sentinel = new LongestCommonSubsequence.Sentinel();
        assertEquals(3, sentinel.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, sentinel.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, sentinel.longestCommonSubsequence("abc", "def"));
    }
}