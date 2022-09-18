package com.algorithm.lookup;

import java.util.*;

/**
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author DragonSong  @date 2022/9/18
 */
public class GetKLeastNumbers {

    static class TreeMapSolution {
        /**
         * 使用treeMap对元素排序、计数
         * 时间复杂度：O(n*logk)
         * 空间复杂度：O(n)
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            NavigableMap<Integer, Integer> num2Cnt = new TreeMap<>(Comparator.naturalOrder());
            int putCnt = 0;
            for (int num : arr) {
                if (putCnt < k) {
                    num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
                    putCnt++;
                } else {
                    // cnt==k 已经放了k个元素
                    Integer lastKey = num2Cnt.lastKey();
                    if (num < lastKey) {
                        Integer lastCnt = num2Cnt.get(lastKey);
                        if (lastCnt == 1) {
                            // 最大值只有一个
                            num2Cnt.pollLastEntry();
                        } else {
                            num2Cnt.put(lastKey, lastCnt - 1);
                        }
                        num2Cnt.put(num, num2Cnt.getOrDefault(num, 0) + 1);
                        putCnt++;
                    }
                }
            }
            int[] ans = new int[k];
            // i表示ans的存储位置
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : num2Cnt.entrySet()) {
                int num = entry.getKey();
                int cnt = entry.getValue();
                for (int j = 0; j < cnt; j++) {
                    ans[i++] = num;
                }
            }
            return ans;
        }
    }

    static class CountingSort {
        /**
         * 数据量有限，使用数组来对每个元素计数
         * 时间复杂度：O(10001)
         * 空间复杂度：O(10001)
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            int[] cntArr = new int[10001];
            for (int num : arr) {
                cntArr[num] += 1;
            }
            int[] ans = new int[k];
            // i遍历cntArr，j存储到ans
            for (int i = 0, j = 0; i < 10001 && j < k; i++) {
                if (cntArr[i] > 0) {
                    for (int ii = 0; ii < cntArr[i] && j < k; ii++) {
                        ans[j++] = i;
                    }
                }
            }
            return ans;
        }
    }

    static class MaxHeap {
        /**
         * 使用最大堆保存最小的k个数，堆顶为k个数中的最大值
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : arr) {
                if (maxHeap.size() < k) {
                    maxHeap.offer(num);
                } else {
                    if (num < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(num);
                    }
                }
            }
            Integer[] resArr = maxHeap.toArray(new Integer[0]);
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = resArr[i];
            }
            return ans;
        }
    }


}
