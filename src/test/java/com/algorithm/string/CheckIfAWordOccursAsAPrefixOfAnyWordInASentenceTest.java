package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentenceTest {

    @Test
    public void isPrefixOfWord() {
        CheckIfAWordOccursAsAPrefixOfAnyWordInASentence service = new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence();
        assertEquals(4, service.isPrefixOfWord("i love eating burger", "burg"));
        assertEquals(2, service.isPrefixOfWord("this problem is an easy problem", "pro"));
        assertEquals(-1, service.isPrefixOfWord("i am tired", "you"));
        assertEquals(4, service.isPrefixOfWord("love errichto jonathan dumb", "dumb"));
    }
}