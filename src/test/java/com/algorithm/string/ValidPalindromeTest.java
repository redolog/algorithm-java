package com.algorithm.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    ValidPalindrome validPalindrome;

    @Before
    public void init(){validPalindrome=new ValidPalindrome();}

    @Test
    public void isPalindrome() {
        assertTrue(validPalindrome.isPalindrome("amanaplanacanalpanama"));
        assertFalse(validPalindrome.isPalindrome("race a car"));
    }

    @Test
    public void isPalindromeTraverse() {
        assertTrue(validPalindrome.isPalindromeTraverse("amanaplanacanalpanama"));
        assertFalse(validPalindrome.isPalindromeTraverse("race a car"));
    }
}