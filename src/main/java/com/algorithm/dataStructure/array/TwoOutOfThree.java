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
