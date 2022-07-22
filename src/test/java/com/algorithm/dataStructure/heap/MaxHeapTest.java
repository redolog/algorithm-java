package com.algorithm.dataStructure.heap;

import com.algorithm.dataStructure.tree.MaxHeap;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxHeapTest {

    MaxHeap maxHeap;

    @Before
    public void init() {
        maxHeap = new MaxHeap(6);
    }

    @Test
    public void insert() {
        for (int element : new int[]{1, 2, 4, 5, 6, 7}) {
            maxHeap.insert(element);
        }

        assertFalse(maxHeap.insert(-1));
        assertFalse(maxHeap.insert(-2));

        assertTrue(Arrays.equals(new int[]{7, 5, 6, 4, 2, 1}, maxHeap.elements) || Arrays.equals(new int[]{7, 5, 6, 1, 4, 2}, maxHeap.elements));
    }

    @Test
    public void getParentIdx() {
        assertEquals(1, maxHeap.getParentIdx(3));
        assertEquals(2, maxHeap.getParentIdx(6));
        assertEquals(2, maxHeap.getParentIdx(5));
        assertEquals(1, maxHeap.getParentIdx(4));
    }

    @Test
    public void getLeftChildIdx() {
        assertEquals(3, maxHeap.getLeftChildIdx(1));
        assertEquals(5, maxHeap.getLeftChildIdx(2));

    }

    @Test
    public void getRightChildIdx() {
        assertEquals(4, maxHeap.getRightChildIdx(1));
        assertEquals(6, maxHeap.getRightChildIdx(2));
    }

    @Test
    public void buildHeap2Down() {
        int[] arr = {0, 1, 2, 4, 5, 6, 7};
        MaxHeap.buildHeap2Down(arr);
        System.out.println(Arrays.toString(arr));
    }
}