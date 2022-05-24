package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;

/**
 * 快速排序
 *
 * @author dragonsong  @date 2022/5/23
 */
public class QuickSort {

    /**
     * 快排基本思想：
     * 1. 基于分治，将大数组排序拆分为小数组排序问题；
     * 2. 首先从本轮处理数组中取一个基准值，作为拆分数组的边界，取名：pivot 支点
     * 3. 类似于选择排序，将数组分为两组：小于pivot的 + 大于pivot的，只不过pivot不是最小值，而是一个基准值（对应左右区间的最大值、最小值）
     * <p>
     * <p>
     * 递推公式：
     * quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1… r)
     * <p>
     * 终止条件：
     * p >= r
     *
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr) {
        if (ArrayUtils.dontNeedSort(arr)) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }
        int pivotIdx = partitionPivotMiddle(arr, leftIdx, rightIdx);
        // 因为pivot值已经放在正确位置上了，所以这里是 pivotIdx-1
        quickSort(arr, leftIdx, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, rightIdx);
    }

    /**
     * 将数组分为两组：小于等于pivot的 + 大于pivot的
     *
     * @param arr      数组
     * @param leftIdx  左待处理闭区间下标
     * @param rightIdx 右待处理闭区间下标
     * @return pivot值对应下标
     */
    private static int partition(int[] arr, int leftIdx, int rightIdx) {
        int pivotVal = arr[rightIdx];

        // i 遍历
        // j 存储
        int i = leftIdx, j = leftIdx;
        for (; i <= rightIdx; ) {
            if (arr[i] <= pivotVal) {
                // 判断当前i是不是快于j？
                if (i > j) {
                    // 交换i、j位置元素
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j++] = tmp;
                } else {
                    arr[j++] = arr[i++];
                }
            } else {
                // 当前值大于 pivot，存储指针不动，继续遍历
                ++i;
            }
        }
        return j - 1;
    }

    /**
     * pivot 可考虑取中间位置的值，左右下标同时向中间靠拢
     */
    private static int partitionPivotMiddle(int[] arr, int leftIdx, int rightIdx) {
        int pivotVal = arr[leftIdx + ((rightIdx - leftIdx) >> 1)];

        while (leftIdx <= rightIdx) {
            // 左侧数据如果小于pivotVal，则持续向中间移动
            while (arr[leftIdx] < pivotVal) {
                ++leftIdx;
            }
            while (arr[rightIdx] > pivotVal) {
                --rightIdx;
            }
            // 上面两个while停下的状态：arr[leftIdx] >= pivotVal && arr[rightIdx] <= pivotVal
            if (leftIdx == rightIdx) {
                return leftIdx;
            }

            ArrayUtils.swap(arr, leftIdx, rightIdx);
        }
        return -1;
    }
}
