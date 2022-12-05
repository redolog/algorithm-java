package com.algorithm.lookup;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class FindTargetIndicesAfterSortingArrayTest {

    @Test
    public void targetIndices() {
        FindTargetIndicesAfterSortingArray.Sort sort = new FindTargetIndicesAfterSortingArray.Sort();
        assertEquals(Arrays.asList(1, 2), sort.targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
        assertEquals(Collections.emptyList(), sort.targetIndices(new int[]{1, 2, 5, 2, 3}, 4));
        assertEquals(Collections.singletonList(4), sort.targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
        assertEquals(Collections.singletonList(3), sort.targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
        FindTargetIndicesAfterSortingArray.Cnt cnt = new FindTargetIndicesAfterSortingArray.Cnt();
        assertEquals(Arrays.asList(1, 2), cnt.targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
        assertEquals(Collections.emptyList(), cnt.targetIndices(new int[]{1, 2, 5, 2, 3}, 4));
        assertEquals(Collections.singletonList(4), cnt.targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
        assertEquals(Collections.singletonList(3), cnt.targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
    }
}