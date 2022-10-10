package com.algorithm.dataStructure.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveAllAdjacentDuplicatesInStringTest {

    @Test
    public void removeDuplicates() {
        RemoveAllAdjacentDuplicatesInString service = new RemoveAllAdjacentDuplicatesInString();
        assertEquals("ca", service.removeDuplicates("abbaca"));
        assertEquals("ca", service.removeDuplicates2("abbaca"));
    }
}