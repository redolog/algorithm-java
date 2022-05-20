package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;

/**
 * 插入排序
 *
 * @author dragonsong  @date 2022/5/20
 */
public class InsertSort {
    /**
     * 插入排序基本思想：
     * - 将数组依旧分为已排序区、待插入元素
     * - 比较多轮；
     * - 待插入元素写入时遍历判断元素位置，如有乱序则触发搬移
     * <p>
     * 过程：
     * 已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 重复这个过程，直到未排序区间中元素为空，算法结束
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
    public static void insertSort(int[] a) {
        if (ArrayUtils.dontNeedSort(a)) {
            return;
        }
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // i表示当前轮数
            // 右侧未排序区待插入元素
            // 每轮拿出上一轮的下一个元素
            int current = a[i];

            // 倒着比较，查找插入位置
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > current) {
                    // 大元素右移
                    a[j + 1] = a[j];
                } else {
                    // 相等 小于边界值的情况，终止比较
                    break;
                }
            }
            // 找到的位置赋值：插入！！！
            a[j + 1] = current;
        }
    }
}
