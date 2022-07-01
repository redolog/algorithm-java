package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumUnitsOnATruckTest {

    MaximumUnitsOnATruck service = new MaximumUnitsOnATruck();

    @Test
    public void maximumUnits() {
        assertEquals(8, service.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        assertEquals(91, service.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
        assertEquals(48, service.maximumUnits(new int[][]{{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}}, 13));
    }

    @Test
    public void maximumUnitsWithHeap() {
        assertEquals(8, service.maximumUnitsWithHeap(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        assertEquals(91, service.maximumUnitsWithHeap(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
        assertEquals(48, service.maximumUnitsWithHeap(new int[][]{{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}}, 13));

    }

    @Test
    public void maximumUnitsWithSort() {
        assertEquals(8, service.maximumUnitsWithSort(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        assertEquals(91, service.maximumUnitsWithSort(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
        assertEquals(48, service.maximumUnitsWithSort(new int[][]{{2, 1}, {4, 4}, {3, 1}, {4, 1}, {2, 4}, {3, 4}, {1, 3}, {4, 3}, {5, 3}, {5, 3}}, 13));

    }
}