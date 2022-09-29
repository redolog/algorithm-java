package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountCommonWordsWithOneOccurrenceTest {

    @Test
    public void countWords() {
        CountCommonWordsWithOneOccurrence service = new CountCommonWordsWithOneOccurrence();
        assertEquals(2, service.countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"}));
        assertEquals(0, service.countWords(new String[]{"b", "bb", "bbb"}, new String[]{"a", "aa", "aaa"}));
        assertEquals(1, service.countWords(new String[]{"a", "ab"}, new String[]{"a", "a", "a", "ab"}));
    }
}