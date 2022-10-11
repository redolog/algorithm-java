package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class OccurrencesAfterBigramTest {

    @Test
    public void findOcurrences() {
        OccurrencesAfterBigram service = new OccurrencesAfterBigram();
        assertArrayEquals(new String[]{"girl", "student"}, service.findOcurrences("alice is a good girl she is a good student", "a", "good"));
        assertArrayEquals(new String[]{"we", "rock"}, service.findOcurrences("we will we will rock you", "we", "will"));
    }
}