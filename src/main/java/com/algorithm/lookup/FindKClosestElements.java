package com.algorithm.lookup;

import java.util.*;
import java.util.stream.Collectors;


/**
 * https://leetcode.cn/problems/find-k-closest-elements/
 *
 * @author dragonsong  @date 2022/8/25
 */
public class FindKClosestElements {
    static class BSearch {
        /**
         * 二分查找，找到距离最近的起点
         * 然后两边扩散，每次取距离更近的，同时注意左右不越界
         * <p>
         * 时间复杂度：二分logn个时间，扩散k个时间，整体 O(logn+k)
         * 空间复杂度：无额外空间开销，O(1)
         */
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 起点，通过二分查找，我们可以先取一个左侧的点
            int r = search(arr, x), l = r - 1;

            // l指向下一个待选的左下标，r指向下一个待选的右下标
            while (k > 0) {
                if (l < 0) {
                    r++;
                } else if (r >= arr.length) {
                    l--;
                } else {
                    int lDistance = Math.abs(arr[l] - x);
                    int rDistance = Math.abs(arr[r] - x);
                    if (lDistance <= rDistance) {
                        l--;
                    } else {
                        r++;
                    }
                }
                k--;
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = l + 1; i < r; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        public List<Integer> findClosestElements2(int[] arr, int k, int x) {
            /*
             * 逐个剔除左右距离更远的数据
             * 时间复杂度：O(n)
             * 空间复杂度：O(1)
             */
            int n = arr.length;
            int l = 0, r = n - 1;
            int removeCnt = n - k;
            while (removeCnt-- > 0) {
                if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                    r--;
                } else {
                    l++;
                }
            }
            List<Integer> ans = new ArrayList<>();

            // 如果 n==k，那么就不会执行剔除过程，因此r边界是不对的，需要根据size K来确定结果集数量
            for (int i = l; i < l + k; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        /**
         * 二分查找，返回距离x最近的左节点
         */
        private int search(int[] arr, int x) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                int mid = l + ((r - l) >> 1);
                if (arr[mid] >= x) {
                    r = mid;
                } else {
                    // arr[mid]<x
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    static class MonotonicDecreasingQueue {
        /**
         * 维护一个单调递减队列，递减性由距离规则决定
         * 时间复杂度：所有元素判断一次，O(n)
         * 空间复杂度：借助了k大小的队列，O(k)
         */
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                queue.offer(arr[i]);
            }
            for (int i = k; i < arr.length; i++) {
                int first = queue.peek();
                int curr = arr[i];
                if (Math.abs(first - x) > Math.abs(curr - x)) {
                    // 当前元素距离更短
                    queue.poll();
                    queue.offer(curr);
                }
                // 当前距离更长，当前元素不应该入队
                // 距离相等，取之前的
            }
            return new ArrayList<>(queue);
        }
    }

    static class Sort {
        /**
         * 根据距离规则排序，取前k个数据，再针对值大小进行一次排序
         * 时间复杂度：O(n*logn + k*logk)
         * 空间复杂度：排序使用栈开销 O(logn + logk)
         */
        // @formatter:off
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            return Arrays.stream(arr)
                    .boxed()
                    // 距离相同取较小值；距离不同取距离更近的值；
                    .sorted((a, b) -> Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x))
                    .limit(k)
                    .sorted()
                    .collect(Collectors.toList());
        }
        // @formatter:on
    }


}
