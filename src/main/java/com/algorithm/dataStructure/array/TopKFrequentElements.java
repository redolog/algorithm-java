package com.algorithm.dataStructure.array;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * <p>
 * https://leetcode.cn/problems/top-k-frequent-elements/
 *
 * @author dragonsong  @date 2022/7/4
 */
public class TopKFrequentElements {

    static class MinHeap {
        /*
         * 执行用时：
         * 13 ms
         * , 在所有 Java 提交中击败了
         * 48.51%
         * 的用户
         * 内存消耗：
         * 43.9 MB
         * , 在所有 Java 提交中击败了
         * 48.69%
         * 的用户
         * 通过测试用例：
         * 21 / 21
         */
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> num2Freq = new HashMap<>();
            for (int num : nums) {
                num2Freq.put(num, num2Freq.getOrDefault(num, 0) + 1);
            }
            // num,freq
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            for (Map.Entry<Integer, Integer> entry : num2Freq.entrySet()) {
                Integer num = entry.getKey();
                Integer freq = entry.getValue();

                if (minHeap.size() == k) {
                    if (freq > minHeap.peek()[1]) {
                        minHeap.poll();
                        minHeap.offer(new int[]{num, freq});
                    }
                } else {
                    minHeap.offer(new int[]{num, freq});
                }

                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = minHeap.peek() != null ? minHeap.poll()[0] : -1;
            }
            return ans;
        }
    }

    static class QuickSort {

        /*
         * 执行用时：
         * 12 ms
         * , 在所有 Java 提交中击败了
         * 89.29%
         * 的用户
         * 内存消耗：
         * 44.2 MB
         * , 在所有 Java 提交中击败了
         * 13.09%
         * 的用户
         * 通过测试用例：
         * 21 / 21
         */

        int ansIdx;

        int[] ans;

        public int[] topKFrequent(int[] nums, int k) {
            // 先统计频率
            Map<Integer, Integer> num2Freq = new HashMap<>();
            for (int num : nums) {
                num2Freq.put(num, num2Freq.getOrDefault(num, 0) + 1);
            }

            int[][] sortArr = new int[num2Freq.keySet().size()][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : num2Freq.entrySet()) {
                Integer num = entry.getKey();
                Integer freq = entry.getValue();
                sortArr[i++] = new int[]{num, freq};
            }

            ans = new int[k];
            ansIdx = 0;
            // 快排
            quickSort(sortArr, k);
            for (; ansIdx < k; ansIdx++) {
                ans[ansIdx] = sortArr[ansIdx][0];
            }
            return ans;
        }

        private void quickSort(int[][] sortArr, int k) {
            qs(sortArr, 0, sortArr.length - 1, k);
        }

        /**
         * 每次选出pivot左右侧大小值后，下一次仅需对一个区间排序，根据主项定理，复杂度为 O(n)
         */
        private void qs(int[][] arr, int l, int r, int k) {
            if (l >= r) {
                return;
            }

            int pivotIdx = partition(arr, l, r, k);

            int lLen = pivotIdx - l + 1;

            if (k <= lLen - 1) {
                // 只需排序左侧
                qs(arr, l, pivotIdx - 1, k);
            } else {
                // 左侧大元素 + (k-lLen)个右侧元素
                // 先装载左侧已排出的大元素
                for (; ansIdx <= pivotIdx; ansIdx++) {
                    ans[ansIdx] = arr[ansIdx][0];
                }
                if (k >= lLen + 1) {
                    // pivot已经排过序了，所以+1
                    // 再对 (k-lLen-1)右侧元素 排序
                    qs(arr, pivotIdx + 1, r, k - (lLen + 1));
                }

            }

        }

        private int partition(int[][] arr, int l, int r, int k) {
            int randomIdx = randomIdx(l, r);
            swap(arr, r, randomIdx);

            int pivotFreq = arr[r][1];

            // i遍历，j存储
            int i = l;
            int j = l;

            while (i <= r) {
                if (arr[i][1] >= pivotFreq) {
                    if (i > j) {
                        swap(arr, i, j);
                    }
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            return j - 1;
        }

        private int randomIdx(int start, int end) {
            return (int) (Math.random() * (end - start + 1)) + start;
        }

        private void swap(int[][] arr, int aIdx, int bIdx) {
            if (aIdx == bIdx) {
                return;
            }

            int[] tmp = arr[aIdx];
            arr[aIdx] = arr[bIdx];
            arr[bIdx] = tmp;
        }

    }

}
