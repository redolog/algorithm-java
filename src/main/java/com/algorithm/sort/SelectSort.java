package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;

/**
 * 选择排序
 *
 * @author dragonsong  @date 2022/5/20
 */
public class SelectSort {

    /*
     * 复杂度分析：
     * 1. 选择排序不需要多余空间，空间复杂度O(1)；
     * 2. 每次选择待选区的最小元素时，按我们下方代码实现，只要保证元素小于当前元素时才更新minIdx【相同元素按序前置到排序区】，就可以保证排序的稳定性；
     * 3. 时间复杂度：
     *  - 最好情况，如 1,2,3,4,5,6 每轮均需要从右侧选一个最小元素，一轮遍历n个元素，一共n轮，时间复杂度为O(n^2)
     *  - 最坏情况，如 6,5,4,3,2,1 同上，复杂度为O(n^2)
     *  - 平均情况，选择排序的时间复杂度与数据的有序度无关，平均时间复杂度为 O(n^2)
     */

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
