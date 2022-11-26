package com.algorithm.lookup;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class FindAllKDistantIndicesInAnArrayTest {

    @Test
    public void findKDistantIndices() {
        FindAllKDistantIndicesInAnArray service = new FindAllKDistantIndicesInAnArray();
        assertTrue(CollectionUtils.equals(Arrays.asList(1, 2, 3, 4, 5, 6), service.findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1)));
        assertTrue(CollectionUtils.equals(Arrays.asList(0, 1, 2, 3, 4), service.findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2)));
    }
}