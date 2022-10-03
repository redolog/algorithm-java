package com.algorithm.dataStructure.array.app.compress;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DecompressRunLengthEncodedListTest {

    @Test
    public void decompressRLElist() {
        DecompressRunLengthEncodedList service = new DecompressRunLengthEncodedList();
        assertArrayEquals(new int[]{2, 4, 4, 4}, service.decompressRLElist(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 3, 3}, service.decompressRLElist(new int[]{1, 1, 2, 3}));
        assertArrayEquals(new int[]{2, 4, 4, 4}, service.decompressRLElist2(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 3, 3}, service.decompressRLElist2(new int[]{1, 1, 2, 3}));
    }
}