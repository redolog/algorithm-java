package com.algorithm.dataStructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/intersection-of-multiple-arrays/
 *
 * @author dragonsong  @date 2022/9/1
 */
public class IntersectionOfMultipleArrays {

    /**
     * 根据题干可知，数组数值最大1000，因此可以用一个1001恒定大小的数组充当hashmap，计数排序的思想
     */
    public List<Integer> intersection(int[][] nums) {
        int[] arr = new int[1001];
        int n = nums.length;
        for (int[] numArr : nums) {
            for (int num : numArr) {
                arr[num]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            if (arr[i] >= n) {
                ans.add(i);
            }
        }
        return ans;
    }
}
