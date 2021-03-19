package com.algorithm.dataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字节面试题： 一个整形数组A，一个整数b，把A中3个数相加等于b的组合全部打印出来。
 * <p>
 * 与LeetCode原题类似：
 *
 * @author DragonSong  @date 2021/3/18
 * @link {https://leetcode-cn.com/problems/3sum/}
 */
public class ThreeSum {

    public List<List<Integer>> solution(int[] arr, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            // 组合去重
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int curr = arr[i];
            if (curr >= targetSum) {
                // 当前值已大于目标
                break;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                // 求和
                int sum = curr + arr[left] + arr[right];
                if (sum == targetSum) {
                    List<Integer> combination = new ArrayList<>();
                    combination.add(curr);
                    combination.add(arr[left]);
                    combination.add(arr[right]);
                    ret.add(combination);
                    // 左右指针还未相遇，并且左指针下一项与当前项相等，直接跳过一级，减少时间消耗
                    while (left < right && arr[left + 1] == arr[left]) {
                        ++left;
                    }
                    while (left < right && arr[right - 1] == arr[right]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (sum < targetSum) {
                    // 寻找下一个大一点的数，挪动左指针
                    ++left;
                } else {
                    // 寻找下一个小一点的数，挪动右指针
                    --right;
                }
            }
        }
        // 最后打印
        for (List<Integer> innerList : ret) {
            System.out.println(innerList);
        }
        return ret;
    }
}
