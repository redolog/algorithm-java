package com.algorithm.dataStructure.array;


import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/reduction-operations-to-make-the-array-elements-equal/
 *
 * @author dragonsong  @date 2022/8/18
 */
public class ReductionOperationToMakeArrayElementsEqual {

    static class CountingSort {

        /**
         * 时间复杂度：O(5 * 10000)
         * 空间复杂度：O(5 * 10000)
         */
        public int reductionOperations(int[] nums) {
            int maxN = 5 * 10000;
            int[] countArr = new int[maxN + 1];
            for (int num : nums) {
                countArr[num]++;
            }
            int ans = 0;
            int step = -1;
            for (int i = 1; i < countArr.length; i++) {
                if (countArr[i] > 0) {
                    step++;
                    ans += countArr[i] * step;
                }
            }

//            List<Integer> numList = new ArrayList<>();
//            for (int i = 1; i < numList.size(); i++) {
//                // numList.get(i) num出现次数
//                // i num距离第一个元素的距离
//                ans += numList.get(i) * i;
//            }
            return ans;
        }
    }

    static class Sort {
        /**
         * 时间复杂度：排序使用 O(n*logn)
         * 空间复杂度：快排使用递归栈消耗 O(logn)
         */
        public int reductionOperations(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            // 距离nums[0]的操作次数
            // 比如 1 3 5 ，最终题干要求都变成1，那么3变成1需要一次操作，5变成1，则需要先变成3再变成1，也就是 op[5-1]=op[5-3]+op[3-1];
            int currOperationCnt = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    currOperationCnt++;
                }
                ans += currOperationCnt;
            }
            return ans;
        }
    }

    static class TreeMapSolution {

        /**
         * 空间复杂度 O(n)
         * 时间复杂度：
         * - 初始化treeMap n*logn，之后进行n轮比较，每次取出数据需要logn
         * - 最优情况下元素初始就等值，比较复杂度 一次logn
         * - 最差情况下每个数据都不等，比较趋近 n^2 次，复杂度 n^2*logn
         * - 综合时间复杂度 n^2*logn
         */
        public int reductionOperations(int[] nums) {
            // int[] arr[0]表示元素值 arr[1]表示元素下标
            // 按元素值增序排序，元素等值按下标排序
            NavigableSet<int[]> set = new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            // nlogn初始化
            for (int i = 0; i < nums.length; i++) {
                set.add(new int[]{nums[i], i});
            }
            int ans = 0;
            while (true) {
                // O(logn)取出最大值
                int[] biggest = set.pollLast();
                // 方便lower直接拿出值比当前元素更小的
                // 同时暂存原最大值、最大值下标
                int tmpBiggestVal = biggest[0];
                int tmpBiggestIdx = biggest[1];
                biggest[0] = biggest[0] - 1;
                biggest[1] = Integer.MAX_VALUE;
                int[] lower = set.lower(biggest);
                if (lower == null || tmpBiggestVal == lower[0]) {
                    return ans;
                }
                biggest[0] = lower[0];
                biggest[1] = tmpBiggestIdx;
                set.add(biggest);
                ans++;
            }
        }
    }

}
