package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountNumberOfHomogenousSubstringsTest {

    @Test
    public void countHomogenous() {
        CountNumberOfHomogenousSubstrings service = new CountNumberOfHomogenousSubstrings();
        assertEquals(13, service.countHomogenous("abbcccaa"));
        assertEquals(2, service.countHomogenous("xy"));
        assertEquals(15, service.countHomogenous("zzzzz"));
    }
}