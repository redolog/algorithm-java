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
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            // i表示当前轮数
            int min = a[i];
            for (int j = i; j < n; j++) {
                // 选择右侧最小元素
                if (a[j] < min) {
                    min = a[j];
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            // 找到的位置赋值：插入！！！
//            a[i] = min;
        }
    }
}
