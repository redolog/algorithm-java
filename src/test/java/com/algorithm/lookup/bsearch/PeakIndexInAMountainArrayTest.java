package com.algorithm.lookup.bsearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeakIndexInAMountainArrayTest {

    @Test
    public void peakIndexInMountainArray() {
        PeakIndexInAMountainArray.Traversal traversal = new PeakIndexInAMountainArray.Traversal();
        assertEquals(1, traversal.peakIndexInMountainArray(new int[]{0, 1, 0}));
        assertEquals(1, traversal.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        assertEquals(1, traversal.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        assertEquals(2, traversal.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        assertEquals(2, traversal.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        PeakIndexInAMountainArray.BSearch bSearch = new PeakIndexInAMountainArray.BSearch();
        assertEquals(1, bSearch.peakIndexInMountainArray(new int[]{0, 1, 0}));
        assertEquals(1, bSearch.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        assertEquals(1, bSearch.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        assertEquals(2, bSearch.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        assertEquals(2, bSearch.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        assertEquals(1, bSearch.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));
    }
}