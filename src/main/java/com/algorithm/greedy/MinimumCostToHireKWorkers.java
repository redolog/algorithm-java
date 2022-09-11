package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/
 *
 * @author DragonSong  @date 2022/9/11
 */
public class MinimumCostToHireKWorkers {

    /**
     * 题干所求最值，有两个要求：
     * 1. 因为k个一组的工资取决于性价比最小的工人（最贵），按照最贵员工来计算其他人的工资比例；因此要求性价比越高越好；
     * 2. 同时，工人总产出越少越好，能满足给大家的工资是最接近期望薪资，也就是公司的总成本会越小；
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        // 性价比从高到低排序：质量/工资 = 性价比
        Integer[] qualityWageRatioIdxArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            qualityWageRatioIdxArr[i] = i;
        }
        // quality[b]/wage[b] 为性价比； b-a 表示倒序；quality[b]/wage[b]-quality[a]/wage[a]
        Arrays.sort(qualityWageRatioIdxArr, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]);

        double ans = Integer.MAX_VALUE;
        int qualitySum = 0;
        // 最大堆，维护k个产出最小的工人，堆顶为k个中产出最大的元素
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int idx : qualityWageRatioIdxArr) {
            int qualityI = quality[idx];
            int wageI = wage[idx];
            // 不满k个，直接添加产出数据到 maxHeap
            // 满了k个，判断当前k个中最大产出是否大于当前i的产出值，大于则替换堆顶元素
            maxHeap.offer(qualityI);
            qualitySum += qualityI;
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                // 总的产出 * (当前工资/当前产出) == 总的工资
                ans = Math.min(ans, wageI * (double) qualitySum / qualityI);
            }
        }
        return ans;
    }
}
