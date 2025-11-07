package com.algorithm.dataStructure.array.intersection;

import java.util.*;

/**
 * https://leetcode.cn/problems/merge-intervals/
 *
 * @author songhuilong  @date 2025/11/7
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // 算法概述：
        // 思路：合并区间类似于消消乐，合并的触发条件为右区间的左边界在左区间的右边界更左（或者相邻），同时为了能依次做相邻判断，可以每个区间的左边界为标准进行排序。
        // 过程：
        // 1. 对输入所有区间以区间左边界为锚点进行升序排序；
        // 2. 对有序的区间进行依次判断，当前区间的右边界 与 下一区间的左边界 相邻或者更右，则合并，取更左+更右作为新区间；
        // 3. 由于过程中存在已合并的区间，当前区间可存放在单独的容器中，符合条件则合并 && 更新当前元素；不符合条件则存放原区间到容器中；
        // 4. 将上述处理完的容器转化为数组返回；
        Deque<int[]> ansQueue = new ArrayDeque<>();
        // 排序时间复杂度：O(n*logn)
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        ansQueue.offerLast(intervals[0]);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            int[] next = intervals[i];
            int nextL = next[0];
            int nextR = next[1];

            int[] curr = ansQueue.peekLast();
            int currL = curr[0];
            int currR = curr[1];
            if (nextL <= currR) {
                // 重合，合并
                ansQueue.pollLast();
                int[] mergedInterval = new int[2];
                mergedInterval[0] = currL;
                mergedInterval[1] = Math.max(currR, nextR);
                ansQueue.offerLast(mergedInterval);
            } else {
                // 不重合，新区间入队
                ansQueue.offerLast(next);
            }
        }

        return ansQueue.toArray(new int[ansQueue.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 存放合并后的元素
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0 || list.get(list.size() - 1)[1] < interval[0]) {
                // 未合并过 || 合并最新的元素与当前区间元素不相交
                list.add(interval);
            } else {
                // 合并元素与当前区间元素相交
                // 合并：左边界一定是list中的更小，因此仅更新右边界
                list.get(list.size() - 1)[1] = Math.max(interval[1], list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
