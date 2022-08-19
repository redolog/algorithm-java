package com.algorithm.dataStructure.array.diff;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 *
 * @author dragonsong  @date 2022/8/19
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

    static class DiffArr {
        /**
         * 使用差分数组记录时间点人数
         * 差分数组大小可以由 time[i]边界确定，由于数据从1开始，同时为了方便做 diff[n+1]-- 操作，我们将r边界设为 max(time[i])+2
         * <p>
         * 时间复杂度：O(startTime.len + queryTime)
         * 空间复杂度：O(maxEndTime + 2)
         */
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int maxEndTime = Arrays.stream(endTime).max().orElse(0);
            if (queryTime > maxEndTime) {
                return 0;
            }
            // diffArr 每一位存储对应时间点在考试人数-上一位的人数差值
            int[] diffArr = new int[maxEndTime + 2];
            for (int i = 0; i < startTime.length; i++) {
                diffArr[startTime[i]]++;
                diffArr[endTime[i] + 1]--;
            }

            int ans = 0;
            for (int i = 1; i <= queryTime; i++) {
                ans += diffArr[i];
            }
            return ans;
        }
    }

    static class BSearch {
        /**
         * startTime[i]恒小于等于 endTime[i]，因此每段时间区间都有效
         * 因此排序后，start、end相对顺序是一致的
         * 找到 startTime<=queryTime 表示目标区间的父集 beforeQueryStart
         * 找到 endTime<queryTime 表示目标区间的反集 beforeQueryEnd
         * <p>
         * beforeQueryStart-beforeQueryEnd 即为所求
         * 求出beforeQueryStart集合的右边界，beforeQueryEnd集合的右边界，下标相减即为元素个数
         * <p>
         * 时间复杂度：排序使用 O(n*logn) 查询单个logn
         * 空间复杂度：O(logn)，排序使用递归栈开销
         */
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            Arrays.sort(startTime);
            Arrays.sort(endTime);
            int n = startTime.length;
            int beforeQueryStart = beforeQueryStart(startTime, 0, n - 1, queryTime);
            int beforeQueryEnd = beforeQueryEnd(endTime, 0, n - 1, queryTime);
            return beforeQueryStart - beforeQueryEnd;
        }

        private int beforeQueryEnd(int[] endTime, int l, int r, int queryTime) {
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (endTime[mid] < queryTime) {
                    if (mid == endTime.length - 1 || endTime[mid + 1] >= queryTime) {
                        return mid;
                    }
                    l = mid + 1;
                } else {
                    // endTime[mid]>=queryTime
                    r = mid - 1;
                }
            }
            return -1;
        }

        private int beforeQueryStart(int[] startTime, int l, int r, int queryTime) {
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (startTime[mid] <= queryTime) {
                    if (mid == startTime.length - 1 || startTime[mid + 1] > queryTime) {
                        return mid;
                    }
                    l = mid + 1;
                } else {
                    // startTime[mid]>queryTime
                    r = mid - 1;
                }
            }
            return -1;
        }
    }
}
