package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;

public class BubbleSort {

    /**
     * 冒泡排序基本思想：
     * - 逐个遍历每个元素，拿当次元素与后续元素进行比较，比较后持有更大元素，同时往后挪动更大元素，一轮遍历后，最大元素挪动到最后
     * - 下一轮重复上个过程，右边界-1
     * <p>
     * 空间复杂度：O(1)
     * 比较发现有相等元素后，持有的更大元素不变，维持排序的稳定性（方便数据获取保留原顺序）
     * 时间复杂度：
     * - 最好：O(n)
     * - 最坏：O(n^2)
     * - 平均：O(n^2)
     *
     * @param a 待排序的数组
     */
    public static void bubbleSort(int[] a) {
        if (ArrayUtils.dontNeedSort(a)) {
            return;
        }
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            // i表示轮数，<n-1 表示比较轮数为n-1
            // 当前轮有没有数据交换
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // j表示本轮需遍历的个数，每轮比较个数为当前未排序数组个数-1

                if (a[j] > a[j + 1]) {
                    // 当前元素大于后一个，等于的情况下不做操作
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swapped = true;
                }

            }
            if (!swapped) {
                // 本轮已经没数据交换了，说明已经排序完全了
                break;
            }
        }
    }
}
