package com.algorithm.dataStructure.array.app.sort;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumAbsoluteDifferenceTest {

    @Test
    public void minimumAbsDifference() {
        MinimumAbsoluteDifference service = new MinimumAbsoluteDifference();
        assertEquals(CollectionUtils.matrixArr2List(new Integer[][]{{1, 2}, {2, 3}, {3, 4}}), service.minimumAbsDifference(new int[]{4, 2, 1, 3}));
        assertEquals(CollectionUtils.matrixArr2List(new Integer[][]{{1, 3}}), service.minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        assertEquals(CollectionUtils.matrixArr2List(new Integer[][]{{-14, -10}, {19, 23}, {23, 27}}), service.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }
}