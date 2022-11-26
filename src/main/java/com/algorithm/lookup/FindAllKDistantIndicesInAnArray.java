package com.algorithm.lookup;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-k-distant-indices-in-an-array/
 *
 * @author songhuilong001  @date 2022/11/26
 */
public class FindAllKDistantIndicesInAnArray {

    /**
     * 使用双指针，保证指针不后退，因此每个元素最多近遍历一次
     * 时间：O(n)
     * 空间：O(1)
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        // j逐个遍历nums，碰到 等于key的元素，开始检查范围
        // i遍历等于key元素的k左右范围
        int n = nums.length;
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] == key) {
                // i-k表示左侧范围最左的位置，i如果在上个区间已经到了最右并且超过了当前区间的最左，需保证i不后退，此时取i本身的值
                i = Math.max(j - k, i);
                while (i < n && Math.abs(i - j) <= k) {
                    ans.add(i);
                    i++;
                }
            }
        }
        return ans;
    }
}
