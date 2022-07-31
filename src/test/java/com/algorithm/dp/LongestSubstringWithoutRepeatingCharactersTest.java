package com.algorithm.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void lengthOfLongestSubstring() {
        LongestSubstringWithoutRepeatingCharacters.DP dp = new LongestSubstringWithoutRepeatingCharacters.DP();
        assertEquals(3, dp.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, dp.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, dp.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, dp.lengthOfLongestSubstring("dvdf"));
        assertEquals(2, dp.lengthOfLongestSubstring("abba"));

        LongestSubstringWithoutRepeatingCharacters.TwoPointer twoPointer = new LongestSubstringWithoutRepeatingCharacters.TwoPointer();
        assertEquals(3, twoPointer.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, twoPointer.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, twoPointer.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, twoPointer.lengthOfLongestSubstring("dvdf"));
        assertEquals(2, twoPointer.lengthOfLongestSubstring("abba"));
        assertEquals(3, twoPointer.lengthOfLongestSubstring2("abcabcbb"));
        assertEquals(1, twoPointer.lengthOfLongestSubstring2("bbbbb"));
        assertEquals(3, twoPointer.lengthOfLongestSubstring2("pwwkew"));
        assertEquals(3, twoPointer.lengthOfLongestSubstring2("dvdf"));
        assertEquals(2, twoPointer.lengthOfLongestSubstring2("abba"));
    }
}