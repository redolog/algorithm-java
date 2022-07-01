package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {

    ReverseWords service = new ReverseWords();

    @Test
    public void reverseWords() {
        assertEquals("blue is sky the", service.reverseWords("the sky is blue"));
        assertEquals("world! hello", service.reverseWords("  hello world!  "));
        assertEquals("example good a", service.reverseWords("a good   example"));

    }

    @Test
    public void reverseWordsTwoPointer() {
        assertEquals("blue is sky the", service.reverseWordsTwoPointer("the sky is blue"));
        assertEquals("world! hello", service.reverseWordsTwoPointer("  hello world!  "));
        assertEquals("example good a", service.reverseWordsTwoPointer("a good   example"));

    }
}