package com.algorithm.string.subString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindTheIndexOfTheFirstOccurrenceInAStringTest {

    @Test
    public void strStr() {
        FindTheIndexOfTheFirstOccurrenceInAString service = new FindTheIndexOfTheFirstOccurrenceInAString();
        assertEquals(0, service.strStr("sadbutsad", "sad"));
        assertEquals(-1, service.strStr("leetcode", "leeto"));
    }
}