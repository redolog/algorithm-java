package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartitionArrayIntoDisjointIntervalsTest {

    @Test
    public void partitionDisjoint() {
        PartitionArrayIntoDisjointIntervals service = new PartitionArrayIntoDisjointIntervals();
        assertEquals(3, service.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        assertEquals(4, service.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
        assertEquals(1, service.partitionDisjoint(new int[]{1, 1}));
        assertEquals(2, service.partitionDisjoint(new int[]{6, 0, 8, 30, 37, 6, 75, 98, 39, 90, 63, 74, 52, 92, 64}));
        assertEquals(1, service.partitionDisjoint(new int[]{26, 51, 40, 58, 42, 76, 30, 48, 79, 91}));
    }
}