package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeStringsAlternatelyTest {

    @Test
    public void mergeAlternately() {
        MergeStringsAlternately service = new MergeStringsAlternately();
        assertEquals("apbqcr", service.mergeAlternately("abc", "pqr"));
        assertEquals("apbqrs", service.mergeAlternately("ab", "pqrs"));
        assertEquals("apbqcd", service.mergeAlternately("abcd", "pq"));
    }
}