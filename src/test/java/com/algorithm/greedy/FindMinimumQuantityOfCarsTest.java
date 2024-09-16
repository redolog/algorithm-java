package com.algorithm.greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMinimumQuantityOfCarsTest {

    @Test
    public void testFindMinimumQuantityOfCars() {
        FindMinimumQuantityOfCars.BinarySearchCollectionSolution binarySearchCollectionSolution = new FindMinimumQuantityOfCars.BinarySearchCollectionSolution();
        FindMinimumQuantityOfCars.BucketSortSolution bucketSortSolution = new FindMinimumQuantityOfCars.BucketSortSolution();
        int[][] testCaseArr = new int[][]{
                {
                        149, 151, 151, 149
                },
                {
                        100, 151, 151, 149
                },
                {
                        100, 100, 100, 149
                },
                {
                        100, 100, 100, 150, 300
                },
        };
        int[] ansArr = new int[]{
                2,
                2,
                2,
                3
        };
        int n = testCaseArr.length;
        for (int i = 0; i < n; i++) {
//            assertEquals(ansArr[i], binarySearchCollectionSolution.findMinimumQuantityOfCars(testCaseArr[i]));
            assertEquals(ansArr[i], bucketSortSolution.findMinimumQuantityOfCars(testCaseArr[i]));
        }
    }

}