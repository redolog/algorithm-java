package com.algorithm.lookup;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GetKLeastNumbersTest {

    @Test
    public void getLeastNumbers() {
        GetKLeastNumbers.MaxHeap maxHeap = new GetKLeastNumbers.MaxHeap();
        assertArrayEquals(new int[]{2, 1}, maxHeap.getLeastNumbers(new int[]{3, 2, 1}, 2));
        assertArrayEquals(new int[]{0}, maxHeap.getLeastNumbers(new int[]{0, 1, 2, 1}, 1));
        GetKLeastNumbers.CountingSort countingSort = new GetKLeastNumbers.CountingSort();
        assertArrayEquals(new int[]{1, 2}, countingSort.getLeastNumbers(new int[]{3, 2, 1}, 2));
        assertArrayEquals(new int[]{0}, countingSort.getLeastNumbers(new int[]{0, 1, 2, 1}, 1));
        assertArrayEquals(new int[]{0, 0, 0, 1, 3, 4, 5, 6, 7}, countingSort.getLeastNumbers(new int[]{0, 0, 1, 3, 4, 5, 0, 7, 6, 7}, 9));
        GetKLeastNumbers.TreeMapSolution treeMapSolution = new GetKLeastNumbers.TreeMapSolution();
        assertArrayEquals(new int[]{1, 2}, treeMapSolution.getLeastNumbers(new int[]{3, 2, 1}, 2));
        assertArrayEquals(new int[]{0}, treeMapSolution.getLeastNumbers(new int[]{0, 1, 2, 1}, 1));
        assertArrayEquals(new int[]{0, 0, 0, 1, 3, 4, 5, 6, 7}, treeMapSolution.getLeastNumbers(new int[]{0, 0, 1, 3, 4, 5, 0, 7, 6, 7}, 9));
    }
}