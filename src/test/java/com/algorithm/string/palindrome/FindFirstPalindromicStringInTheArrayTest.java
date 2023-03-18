package com.algorithm.string.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindFirstPalindromicStringInTheArrayTest {

    @Test
    public void firstPalindrome() {
        FindFirstPalindromicStringInTheArray service = new FindFirstPalindromicStringInTheArray();
        assertEquals("ada", service.firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        assertEquals("racecar", service.firstPalindrome(new String[]{"notapalindrome", "racecar"}));
        assertEquals("", service.firstPalindrome(new String[]{"def", "ghi"}));
    }
}