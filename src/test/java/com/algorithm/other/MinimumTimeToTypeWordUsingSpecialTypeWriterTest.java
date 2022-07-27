package com.algorithm.other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumTimeToTypeWordUsingSpecialTypeWriterTest {

    @Test
    public void minTimeToType() {
        MinimumTimeToTypeWordUsingSpecialTypeWriter service = new MinimumTimeToTypeWordUsingSpecialTypeWriter();
        assertEquals(5, service.minTimeToType("abc"));
        assertEquals(7, service.minTimeToType("bza"));
        assertEquals(34, service.minTimeToType("zjpc"));
    }
}