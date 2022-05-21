package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;

/**
 * 选择排序
 *
 * @author dragonsong  @date 2022/5/20
 */
public class SelectSort {
    /**
     * 选择排序基本思想：
     * - 将数组依旧分为已排序区、待插入元素
     * - 每一轮从右侧未排序区找出最小元素，插入到左侧最末端；
     * <p>
     * 空间复杂度：O(1)
     * 时间复杂度：
     * - 最好：O(n^2)
     * - 最坏：O(n^2)
     * - 平均：O(n^2)
     * <p>
     * 缺陷：选择排序不稳定，每次都需要将右侧最小元素插入到左侧
     *
     * @param a 待排序的数组
     */
    public static void selectSort(int[] a) {
        if (ArrayUtils.dontNeedSort(a)) {
            return;
        }
        // 选择排序：数组分左排序区间+右未排序区间。每一轮从右侧找出最小值，插入到左侧最末端。形成的数组为有序数组。
        for (int i = 0; i < a.length; i++) {
            int minIdx = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[minIdx];
                a[minIdx] = a[i];
                a[i] = tmp;
            }
        }
    }
}
