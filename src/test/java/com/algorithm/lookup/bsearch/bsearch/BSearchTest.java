package com.algorithm.lookup.bsearch.bsearch;

import com.algorithm.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static com.algorithm.lookup.bsearch.bsearch.BSearch.bsearch;
import static com.algorithm.lookup.bsearch.bsearch.BSearch.bsearchRecursive;
import static org.junit.Assert.assertEquals;

public class BSearchTest {

    private static final int BATCH_SIZE = 10000;

    @Test
    public void bsearchTest() {
        assertEquals(bsearch(new int[]{50, 70, 70, 80, 80}, 50), 50);
        assertEquals(bsearch(new int[]{70, 70, 80, 80, 100}, 80), 80);
        assertEquals(bsearch(new int[]{50, 50, 60, 70, 70, 80, 80}, 80), 80);
        assertEquals(bsearch(new int[]{50, 50, 70, 70, 80, 80, 90, 100, 100}, 70), 70);

        assertEquals(bsearchRecursive(new int[]{50, 70, 70, 80, 80}, 50), 50);
        assertEquals(bsearchRecursive(new int[]{70, 70, 80, 80, 100}, 80), 80);
        assertEquals(bsearchRecursive(new int[]{50, 50, 60, 70, 70, 80, 80}, 80), 80);
        assertEquals(bsearchRecursive(new int[]{50, 50, 70, 70, 80, 80, 90, 100, 100}, 70), 70);
    }

    @Test
    public void findLeftMostBiggerEqualIndexTest() {
        for (int i = 0; i < BATCH_SIZE; i++) {
            int[] arr = ArrayUtils.createArrayByRandomLenAndVal(10 + i, 100 + i);
            Arrays.sort(arr);

            System.out.println(Arrays.toString(arr));

            int idxRude = BSearch.findLeftMostBiggerEqualIndexRude(arr, 6);
            int idx = BSearch.findLeftMostBiggerEqualIndex(arr, 6);

            int idxOld = BSearchFindFirstBiggerOrEqual.bsearchFindFirstBiggerOrEqual(arr, 6);

            System.out.println("idxRude::" + idxRude);
            System.out.println("idx::" + idx);
            System.out.println("idxOld::" + idxOld);
            Assert.assertEquals(idxRude, idx);
            Assert.assertEquals(idxRude, idxOld);
        }

    }
}