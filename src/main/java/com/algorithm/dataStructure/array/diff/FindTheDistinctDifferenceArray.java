package com.algorithm.dataStructure.array.diff;

import java.awt.font.NumericShaper;
import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/find-the-distinct-difference-array/">2670. 找出不同元素数目差数组</a>
 *
 * @author songhuilong  @date 2023/5/12
 */
public class FindTheDistinctDifferenceArray {
    /**
     * <p>
     * 求：
     * diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
     * <p>
     * 基本思路：
     * 1. 正序遍历，使用set去重，维护每个i下标位置对应的不同元素数；
     * 2. 倒序遍历，维护每个i下标位置对应后序区间不同的元素数；
     */
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] forwardDiffCnt = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            forwardDiffCnt[i] = set.size();
        }
        set.clear();
        int[] backwardDiffCnt = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            set.add(nums[i]);
            backwardDiffCnt[i] = set.size();
        }

        int[] diffArr = new int[n];
        for (int i = 0; i < n; i++) {
            diffArr[i] = forwardDiffCnt[i] - backwardDiffCnt[i + 1];
        }
        return diffArr;
    }

    public int[] distinctDifferenceArray2(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] backwardDiffCnt = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            set.add(nums[i]);
            backwardDiffCnt[i] = set.size();
        }
        set.clear();

        int[] diffArr = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            diffArr[i] = set.size() - backwardDiffCnt[i + 1];
        }
        return diffArr;
    }

}
