package com.algorithm.greedy;

import org.junit.Test;

public class AdvantageShuffleTest {

    @Test
    public void advantageCount() {
        AdvantageShuffle.SortBinarySearch sortBinarySearch = new AdvantageShuffle.SortBinarySearch();
        sortBinarySearch.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
        sortBinarySearch.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        sortBinarySearch.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2});
        sortBinarySearch.advantageCount(new int[]{5621, 1743, 5532, 3549, 9581}, new int[]{913, 9787, 4121, 5039, 1481});
        AdvantageShuffle.SortedMapSolution sortedMapSolution = new AdvantageShuffle.SortedMapSolution();
        sortedMapSolution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
        sortedMapSolution.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        sortedMapSolution.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2});
        sortedMapSolution.advantageCount(new int[]{5621, 1743, 5532, 3549, 9581}, new int[]{913, 9787, 4121, 5039, 1481});
    }
}