package com.algorithm.dataStructure.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songhuilong  @date 2023/3/28
 * @link {<a href="https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/">...</a>}
 */
public class MergeTwo2DArraysBySummingValues {

    /**
     * 题干关键信息：
     * 1. 数组中每项为 [idi, vali] 表示idi的值为vali；
     * 2. id在每个数组中升序排列；
     * 3. 单个id在单个数组中仅出现一次；
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> ansList = new ArrayList<>();
        int n1 = nums1.length, n2 = nums2.length, i1 = 0, i2 = 0;
        while (i1 < n1 || i2 < n2) {
            int val1 = Integer.MAX_VALUE, id1 = Integer.MAX_VALUE;
            if (i1 < n1) {
                int[] num1 = nums1[i1];
                id1 = num1[0];
                val1 = num1[1];
            }
            int val2 = Integer.MAX_VALUE, id2 = Integer.MAX_VALUE;
            if (i2 < n2) {
                int[] num2 = nums2[i2];
                id2 = num2[0];
                val2 = num2[1];
            }

            if (id1 == 0 || id1 > id2) {
                // 当前取num2
                ansList.add(new int[]{id2, val2});
                i2++;
            } else if (id2 == 0 || id2 > id1) {
                // 当前取num1
                ansList.add(new int[]{id1, val1});
                i1++;
            } else {
                // 当前取num1+num2
                ansList.add(new int[]{id1, val1 + val2});
                i1++;
                i2++;
            }
        }

        int n = ansList.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
