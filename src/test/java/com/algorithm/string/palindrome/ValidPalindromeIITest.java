package com.algorithm.string.palindrome;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeIITest {

    @Test
    public void validPalindrome() {
        ValidPalindromeII.BF bf = new ValidPalindromeII.BF();
        assertTrue(bf.validPalindrome("aba"));
        assertTrue(bf.validPalindrome("abca"));
        assertFalse(bf.validPalindrome("abc"));
        ValidPalindromeII.TwoPointer twoPointer = new ValidPalindromeII.TwoPointer();
        assertTrue(twoPointer.validPalindrome("aba"));
        assertTrue(twoPointer.validPalindrome("abca"));
        assertFalse(twoPointer.validPalindrome("abc"));
    }
}