package com.algorithm.dataStructure.array.app.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-absolute-difference/
 *
 * @author songhuilong  @date 2023/2/6
 */
public class MinimumAbsoluteDifference {

    /**
     * 时间：O(n*logn)
     * 空间：O(logn)
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> ansList = new ArrayList<>();
        int n = arr.length, minDiff = Integer.MAX_VALUE;
        // i表示当前，i+1表示next
        for (int i = 0; i < n - 1; i++) {
            // 负数减负数 为正；正数减负数 为正；大正数减小正数 为正；
            int curr = arr[i], next = arr[i + 1], diff = next - curr;
            if (diff < minDiff) {
                minDiff = diff;
                // 发现了更小的距离，之前添加的数对都可以清空了
                ansList.clear();
                List<Integer> pair = new ArrayList<>(2);
                pair.add(curr);
                pair.add(next);
                ansList.add(pair);
            } else if (diff == minDiff) {
                List<Integer> pair = new ArrayList<>(2);
                pair.add(curr);
                pair.add(next);
                ansList.add(pair);
            }
        }
        return ansList;
    }
}
