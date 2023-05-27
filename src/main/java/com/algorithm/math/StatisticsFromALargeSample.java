package com.algorithm.math;

/**
 * https://leetcode.cn/problems/statistics-from-a-large-sample/
 *
 * @author songhuilong001  @date 2023/5/27
 */
public class StatisticsFromALargeSample {

    int[] countArr;

    public double[] sampleStats(int[] count) {
        countArr = count;
        // 最小值
        int min = 256,
                // 最大值
                max = -1,
                // 所有元素出现次数和
                cntSum = 0,
                // 保证唯一的众数
                mode = 0;

        // 所有元素和
        long sum = 0,
                // 元素出现次数最大值（众数对应频率）
                cntMax = 0;
        int n = count.length;
        for (int i = 0; i < n; i++) {
            int cnt = count[i];
            if (cnt == 0) {
                continue;
            }
            if (min == 256) {
                min = i;
            }
            max = i;
            if (cnt > cntMax) {
                cntMax = cnt;
                mode = i;
            }
            sum += (long) i * cnt;
            cntSum += cnt;
        }

        double[] ans = {min, max, (double) sum / cntSum, calcMedian(cntSum), mode};
        return ans;
    }

    private double calcMedian(int cntSum) {
        double median;
        if (cntSum % 2 == 0) {
            median = (query(cntSum / 2) + query(cntSum / 2 + 1)) / 2.0;
        } else {
            median = query(cntSum / 2 + 1);
        }
        return median;
    }

    /**
     * 根据排序下标，定位 count 数组平铺后对应位置数据
     *
     * @param i 排序后的下标
     */
    private int query(int i) {
        // j为平铺后的下标，num为平铺后的元素值
        for (int j = 0, num = 0; j < i; num++) {
            j += countArr[num];
            if (j >= i) {
                return num;
            }
        }
        return -1;
    }
}
