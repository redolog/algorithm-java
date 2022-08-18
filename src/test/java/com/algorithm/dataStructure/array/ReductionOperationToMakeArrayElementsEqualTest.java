package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReductionOperationToMakeArrayElementsEqualTest {

    @Test
    public void reductionOperations() {
        // TreeMap 会超时
        ReductionOperationToMakeArrayElementsEqual.TreeMapSolution treeMap = new ReductionOperationToMakeArrayElementsEqual.TreeMapSolution();
        assertEquals(3, treeMap.reductionOperations(new int[]{5, 1, 3}));
        assertEquals(0, treeMap.reductionOperations(new int[]{1, 1, 1}));
        assertEquals(4, treeMap.reductionOperations(new int[]{1, 1, 2, 2, 3}));
        assertEquals(45, treeMap.reductionOperations(new int[]{7, 9, 10, 8, 6, 4, 1, 5, 2, 3}));

        ReductionOperationToMakeArrayElementsEqual.Sort sort = new ReductionOperationToMakeArrayElementsEqual.Sort();
        assertEquals(3, sort.reductionOperations(new int[]{5, 1, 3}));
        assertEquals(0, sort.reductionOperations(new int[]{1, 1, 1}));
        assertEquals(4, sort.reductionOperations(new int[]{1, 1, 2, 2, 3}));
        assertEquals(45, sort.reductionOperations(new int[]{7, 9, 10, 8, 6, 4, 1, 5, 2, 3}));

        ReductionOperationToMakeArrayElementsEqual.CountingSort countingSort = new ReductionOperationToMakeArrayElementsEqual.CountingSort();
        assertEquals(3, countingSort.reductionOperations(new int[]{5, 1, 3}));
        assertEquals(0, countingSort.reductionOperations(new int[]{1, 1, 1}));
        assertEquals(4, countingSort.reductionOperations(new int[]{1, 1, 2, 2, 3}));
        assertEquals(45, countingSort.reductionOperations(new int[]{7, 9, 10, 8, 6, 4, 1, 5, 2, 3}));
    }
}