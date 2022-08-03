package com.algorithm.company.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a demo task.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 *
 * @author dragonsong  @date 2022/8/3
 */
public class SmallestPositiveInteger {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int smallestPositiveInteger(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        // O(n)
        for (int num : arr) {
            set.add(num);
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
