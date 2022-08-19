package com.algorithm.dataStructure.array;

import com.algorithm.util.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class KClosestPointsToOriginTest {

    @Test
    public void kClosest() {
        KClosestPointsToOrigin service = new KClosestPointsToOrigin();
        assertArrayEquals(new int[][]{{-2, 2}}, service.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        assertArrayEquals(new int[][]{{3, 3}, {-2, 4}}, service.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
        KClosestPointsToOrigin.Heap maxHeap = new KClosestPointsToOrigin.Heap();
        assertTrue(ArrayUtils.containEquals(new int[][]{{-2, 2}}, maxHeap.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        assertTrue(ArrayUtils.containEquals(new int[][]{{3, 3}, {-2, 4}}, maxHeap.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}