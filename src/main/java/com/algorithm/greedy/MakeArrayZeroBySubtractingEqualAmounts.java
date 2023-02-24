package com.algorithm.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
 *
 * @author songhuilong  @date 2023/2/24
 */
public class MakeArrayZeroBySubtractingEqualAmounts {

    static class BucketSortSolution {
        public int minimumOperations(int[] nums) {
            int[] numCnt = new int[101];
            for (int num : nums) {
                numCnt[num]++;
            }

            int ans = 0;
            boolean havePositive = true;
            while (havePositive) {
                int min = 0;
                havePositive = false;
                for (int i = 1; i < 101; i++) {
                    if (numCnt[i] == 0) {
                        continue;
                    }
                    havePositive = true;
                    if (min == 0) {
                        min = i;
                    } else {
                        numCnt[i - min] = numCnt[i];
                    }
                    numCnt[i] = 0;
                }
                if (havePositive) {
                    ans++;
                }
            }
            return ans;
        }
    }

    static class SetSolution {
        public int minimumOperations(int[] nums) {
//            return Arrays.stream(nums)
//                    .filter(num -> num > 0)
//                    .boxed()
//                    .collect(Collectors.toSet())
//                    .size();
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (num > 0) {
                    set.add(num);
                }
            }
            return set.size();
        }
    }

}
