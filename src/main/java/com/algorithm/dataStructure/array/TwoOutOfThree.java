package com.algorithm.dataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/two-out-of-three/
 *
 * @author songhuilong  @date 2022/12/29
 */
public class TwoOutOfThree {

    static class BitSolution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            // 以二进制位计数，相同数在相同数组中只计数一次，如nums1 在 cntArr[num] |= bitOffset 上做标记
            int[] cntArr = new int[101];
            calcDistinctCnt(nums1, cntArr, 1);
            calcDistinctCnt(nums2, cntArr, 2);
            calcDistinctCnt(nums3, cntArr, 4);

            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < cntArr.length; i++) {
                if ((cntArr[i] & (cntArr[i] - 1)) > 1) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private void calcDistinctCnt(int[] nums, int[] cntArr, int bitOffset) {
            for (Integer num : nums) {
                cntArr[num] = cntArr[num] | bitOffset;
            }
        }
    }

    static class SetSolution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[] cntArr = new int[101];
            calcDistinctCnt(nums1, cntArr);
            calcDistinctCnt(nums2, cntArr);
            calcDistinctCnt(nums3, cntArr);

            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < cntArr.length; i++) {
                if (cntArr[i] >= 2) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private void calcDistinctCnt(int[] nums, int[] cntArr) {
            Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            for (Integer num : numSet) {
                cntArr[num]++;
            }
        }
    }
}
