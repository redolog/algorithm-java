package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecryptStringFromAlphabetToIntegerMappingTest {

    @Test
    public void freqAlphabets() {
        DecryptStringFromAlphabetToIntegerMapping service = new DecryptStringFromAlphabetToIntegerMapping();
        assertEquals("jkab", service.freqAlphabets("10#11#12"));
        assertEquals("acz", service.freqAlphabets("1326#"));
    }
}