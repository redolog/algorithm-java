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
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = curr + arr[left] + arr[right];
                if (sum == targetSum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    ret.add(list);
                    while (left < right && arr[left + 1] == arr[left]) {
                        ++left;
                    }
                    while (left < right && arr[right - 1] == arr[right]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (sum < targetSum) {
                    ++left;
                } else {
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
