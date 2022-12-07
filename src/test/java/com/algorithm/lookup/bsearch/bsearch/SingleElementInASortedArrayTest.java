package com.algorithm.lookup.bsearch.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleElementInASortedArrayTest {

    @Test
    public void singleNonDuplicate() {
        SingleElementInASortedArray service = new SingleElementInASortedArray();
        assertEquals(2, service.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, service.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }
}