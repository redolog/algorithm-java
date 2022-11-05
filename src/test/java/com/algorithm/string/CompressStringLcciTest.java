package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompressStringLcciTest {

    @Test
    public void compressString() {
        CompressStringLcci service = new CompressStringLcci();
        assertEquals("a2b1c5a3", service.compressString("aabcccccaaa"));
        assertEquals("abbccd", service.compressString("abbccd"));
    }
}