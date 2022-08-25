package com.algorithm.lookup;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestElementInAnArrayTest {

    @Test
    public void findKthLargestWithQuickSortPivot() {
        KthLargestElementInAnArray service = new KthLargestElementInAnArray();

        Assert.assertEquals(5, service.findKthLargestWithQuickSortPivot(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assert.assertEquals(4, service.findKthLargestWithQuickSortPivot(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }

    @Test
    public void findKthLargestWithMinHeap() {
        KthLargestElementInAnArray service = new KthLargestElementInAnArray();

        Assert.assertEquals(5, service.findKthLargestWithMinHeap(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assert.assertEquals(4, service.findKthLargestWithMinHeap(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    public void findKthLargestWithPriorityQueue() {
        KthLargestElementInAnArray service = new KthLargestElementInAnArray();

        Assert.assertEquals(5, service.findKthLargestWithPriorityQueue(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assert.assertEquals(4, service.findKthLargestWithPriorityQueue(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}