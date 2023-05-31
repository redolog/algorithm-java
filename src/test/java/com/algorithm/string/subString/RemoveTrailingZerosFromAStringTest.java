package com.algorithm.string.subString;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveTrailingZerosFromAStringTest {

    @Test
    public void removeTrailingZeros() {
        RemoveTrailingZerosFromAString service = new RemoveTrailingZerosFromAString();
        assertEquals("512301", service.removeTrailingZeros("51230100"));
        assertEquals("123", service.removeTrailingZeros("123"));
    }
}