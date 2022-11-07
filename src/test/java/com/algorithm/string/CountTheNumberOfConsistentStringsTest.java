package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountTheNumberOfConsistentStringsTest {

    @Test
    public void countConsistentStrings() {
        CountTheNumberOfConsistentStrings service = new CountTheNumberOfConsistentStrings();
        assertEquals(2, service.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        assertEquals(7, service.countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        assertEquals(4, service.countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }
}