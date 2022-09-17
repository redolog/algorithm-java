package com.algorithm.string.subString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestSubstringBetweenTwoEqualCharactersTest {

    @Test
    public void maxLengthBetweenEqualCharacters() {
        LargestSubstringBetweenTwoEqualCharacters service = new LargestSubstringBetweenTwoEqualCharacters();
        assertEquals(0, service.maxLengthBetweenEqualCharacters("aa"));
        assertEquals(2, service.maxLengthBetweenEqualCharacters("abca"));
        assertEquals(-1, service.maxLengthBetweenEqualCharacters("cbzxy"));
        assertEquals(4, service.maxLengthBetweenEqualCharacters("cabbac"));
        assertEquals(0, service.maxLengthBetweenEqualCharacters2("aa"));
        assertEquals(2, service.maxLengthBetweenEqualCharacters2("abca"));
        assertEquals(-1, service.maxLengthBetweenEqualCharacters2("cbzxy"));
        assertEquals(4, service.maxLengthBetweenEqualCharacters2("cabbac"));
    }
}