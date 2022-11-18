package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindPeakElementTest {

    @Test
    public void findPeakElement() {
        FindPeakElement service = new FindPeakElement();
        assertEquals(2, service.findPeakElement(new int[]{1, 2, 3, 1}));
        assertEquals(5, service.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        assertEquals(0, service.findPeakElement(new int[]{1}));
        assertEquals(0, service.findPeakElement(new int[]{3, 1, 2}));
        assertEquals(1, service.findPeakElement(new int[]{3, 4, 3, 2, 1}));
    }
}