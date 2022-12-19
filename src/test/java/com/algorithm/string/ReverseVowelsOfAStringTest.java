package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseVowelsOfAStringTest {

    @Test
    public void reverseVowels() {
        ReverseVowelsOfAString service = new ReverseVowelsOfAString();
        assertEquals("holle", service.reverseVowels("hello"));
        assertEquals("leotcede", service.reverseVowels("leetcode"));
    }
}