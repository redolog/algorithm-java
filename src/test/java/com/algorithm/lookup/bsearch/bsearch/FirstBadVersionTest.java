package com.algorithm.lookup.bsearch.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstBadVersionTest {

    @Test
    public void firstBadVersion() {
        FirstBadVersion service = new FirstBadVersion();
        assertEquals(4, service.firstBadVersion(5, 4));
        assertEquals(1, service.firstBadVersion(1, 1));
    }
}