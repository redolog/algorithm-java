package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountElementsWithStrictlySmallerANdGreaterElementsTest {

    @Test
    public void countElements() {
        CountElementsWithStrictlySmallerAndGreaterElements service = new CountElementsWithStrictlySmallerAndGreaterElements();
        assertEquals(2, service.countElements(new int[]{11, 7, 2, 15}));
        assertEquals(2, service.countElements(new int[]{-3, 3, 3, 90}));
        assertEquals(0, service.countElements(new int[]{-3, 3}));
        assertEquals(0, service.countElements(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
    }
}