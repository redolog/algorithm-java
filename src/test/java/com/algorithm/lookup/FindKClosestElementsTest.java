package com.algorithm.lookup;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class FindKClosestElementsTest {

    @Test
    public void findClosestElements() {
        FindKClosestElements.Sort sort = new FindKClosestElements.Sort();
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), sort.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), sort.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1)));
        assertTrue(CollectionUtils.equals(Collections.singletonList(10), sort.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9)));

        FindKClosestElements.MonotonicDecreasingQueue queue = new FindKClosestElements.MonotonicDecreasingQueue();
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), queue.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), queue.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1)));
        assertTrue(CollectionUtils.equals(Collections.singletonList(10), queue.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9)));

        FindKClosestElements.BSearch bSearch = new FindKClosestElements.BSearch();
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), bSearch.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), bSearch.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1)));
        assertTrue(CollectionUtils.equals(Collections.singletonList(10), bSearch.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), bSearch.findClosestElements2(new int[]{1, 2, 3, 4, 5}, 4, 3)));
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4), bSearch.findClosestElements2(new int[]{1, 2, 3, 4, 5}, 4, -1)));
        assertTrue(CollectionUtils.equals(Collections.singletonList(10), bSearch.findClosestElements2(new int[]{1, 1, 1, 10, 10, 10}, 1, 9)));
    }
}