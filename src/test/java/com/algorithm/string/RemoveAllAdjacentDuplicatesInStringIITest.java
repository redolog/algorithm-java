package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveAllAdjacentDuplicatesInStringIITest {

    @Test
    public void removeDuplicates() {
        RemoveAllAdjacentDuplicatesInStringII service = new RemoveAllAdjacentDuplicatesInStringII();
        assertEquals("abcd", service.removeDuplicates("abcd", 2));
        assertEquals("aa", service.removeDuplicates("deeedbbcccbdaa", 3));
        assertEquals("ps", service.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}