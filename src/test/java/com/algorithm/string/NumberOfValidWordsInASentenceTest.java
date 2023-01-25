package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOfValidWordsInASentenceTest {

    @Test
    public void countValidWords() {
        NumberOfValidWordsInASentence service = new NumberOfValidWordsInASentence();
        assertEquals(3, service.countValidWords("cat and  dog"));
        assertEquals(0, service.countValidWords("!this  1-s b8d!"));
        assertEquals(0, service.countValidWords("a-b-c"));
        assertEquals(5, service.countValidWords("alice and  bob are playing stone-game10"));
    }
}