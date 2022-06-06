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
        assertFalse(validPalindrome.isPalindrome("OP"));
        assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(validPalindrome.isPalindrome("amanaplanacanalpanama"));
        assertFalse(validPalindrome.isPalindrome("race a car"));
    }

    @Test
    public void isPalindromeTraverse() {
        assertFalse(validPalindrome.isPalindromeTraverse("OP"));
        assertTrue(validPalindrome.isPalindromeTraverse("A man, a plan, a canal: Panama"));
        assertTrue(validPalindrome.isPalindromeTraverse("amanaplanacanalpanama"));
        assertFalse(validPalindrome.isPalindromeTraverse("race a car"));
    }
}