package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;

/**
 * 插入排序
 *
 * @author dragonsong  @date 2022/5/20
 */
public class InsertSort {

    /*
     * 复杂度分析：
     * 1. 插入比较、交换均为原地操作，空间复杂度O(1)；
     * 2. 元素比较大小时，只有元素小于当前元素才涉及交换操作【相同大小不挪动】，保证后比较的元素在靠后的位置，可以保证排序的稳定性；
     * 3. 时间复杂度：
     *  - 最好情况，如 1,2,3,4,5,6 每个元素只需在当前位置与前一个元素比较一次，总共操作n次，时间复杂度为O(n)
     *  - 最坏情况，如 6,5,4,3,2,1 有序度最小逆序度最大，每个元素都需要插入到arr[0]的位置，复杂度为O(n^2)
     *  - 平均情况，数组中插入一个数据的平均时间复杂度是 O(n)。所以，插入排序每次插入操作都相当于在数组中插入一个数据，循环执行 n 次插入操作，所以平均时间复杂度为 O(n^2)
     *
     * insertSort 中赋值的写法在复杂场景下的实现对比冒泡排序有性能优势，赋值写法比swap代价低。
     */

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

    /**
     * 使用 swap 操作，代码行数少，但是 swap 操作复杂度比 insertSort 中的实现高：
     * <p>
     * swap vs  a[j + 1] = a[j]
     */
    public static void insertSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 插入排序
        int n = arr.length;
        // 最开始我们从下标1的元素开始向左比较，所以 startIdx=1
        for (int startIdx = 1; startIdx < n; startIdx++) {
            // 表示遍历下标
            int currentIdx = startIdx;
            while (currentIdx - 1 >= 0 && arr[currentIdx] < arr[currentIdx - 1]) {
                ArrayUtils.swap(arr, currentIdx, currentIdx - 1);
                currentIdx--;
            }
        }
    }

    public static void insertSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 插入排序
        int n = arr.length;
        // 最开始我们从下标1的元素开始向左比较，所以 startIdx=1
        for (int startIdx = 1; startIdx < n; startIdx++) {

            for (int currentIdx = startIdx; currentIdx - 1 >= 0 && arr[currentIdx] < arr[currentIdx - 1]; currentIdx--) {
                ArrayUtils.swap(arr, currentIdx, currentIdx - 1);
            }
        }
    }
}
