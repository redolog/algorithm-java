package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpecialArrayWithXElementsGreaterThanOrEqualXTest {

    @Test
    public void specialArray() {
        SpecialArrayWithXElementsGreaterThanOrEqualX service = new SpecialArrayWithXElementsGreaterThanOrEqualX();
        assertEquals(2, service.specialArray(new int[]{3, 5}));
        assertEquals(-1, service.specialArray(new int[]{0, 0}));
        assertEquals(-1, service.specialArray(new int[]{3, 6, 7, 7, 0}));
        assertEquals(-1, service.specialArray(new int[]{1, 1, 2}));
        assertEquals(-1, service.specialArray(new int[]{1, 3, 9, 5, 11, 2, 11, 0, 4, 2}));
        assertEquals(3, service.specialArray(new int[]{0, 4, 3, 0, 4}));
        assertEquals(3, service.specialArray(new int[]{2, 0, 6, 0, 0, 7, 7, 0}));
        assertEquals(6, service.specialArray(new int[]{3, 9, 7, 8, 3, 8, 6, 6}));
        assertEquals(100, service.specialArray(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
    }
}