package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;

/**
 * 归并排序
 *
 * @author dragonsong  @date 2022/5/23
 */
public class MergeSort {

    /*
     * 复杂度分析：
     * 1. 归并排序的merge操作需要额外的tmpArr空间，并且每一轮递归执行merge时的空间依次为2^1 2^2 2^3 2^x 其中 x=log2n，但是由于每一轮申请的tmpArr合并后就释放空间了，所以空间复杂度O(n)；
     * 2. merge时，碰到相等元素时，先将左数组元素放入tmpArr，可以保证排序的稳定性；
     * 3. 时间复杂度：
     *  - 最好情况
     *  - 最坏情况
     *  - 平均情况
     *  - 由于归并排序操作次数与原数据有序度无关，所以最好、最坏、平均情况的时间复杂度一致。n个数据，涉及 log2n 轮的递归调用，每一轮内对拆分区间内【规模为n】的数据合并，因此，时间复杂度为 O(logn*n)
     */

    /**
     * 归并排序基本思想：
     * 1. DC 分治：把大数组排序问题转换为多个小数组排序问题，一直拆分，直到数组变成单个元素（已排序状态）；
     * 2. 拆分到底之后，依次合并小数组（合并两个有序数组）；
     * <p>
     * 缺陷：
     * 不是原地排序算法。有多余空间消耗。
     */
    public static void mergeSort(int[] a) {
        if (ArrayUtils.dontNeedSort(a)) {
            return;
        }
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * 递归归并排序函数
     * <p>
     * <p>
     * 递推公式：
     * merge_sort(startIdx…endIdx) = merge(merge_sort(startIdx…middleIdx), merge_sort(middleIdx+1…endIdx))
     * <p>
     * 终止条件：
     * startIdx >= endIdx 不用再继续分解
     *
     * @param a        待排序数组
     * @param startIdx 左闭区间下标
     * @param endIdx   右闭区间下标
     */
    public static void mergeSort(int[] a, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }

        // 取中点
        int middleIdx = startIdx + ((endIdx - startIdx) >> 1);
        // 拆分、递归排序
        mergeSort(a, startIdx, middleIdx);
        mergeSort(a, middleIdx + 1, endIdx);
        // 合并排序结果
        mergeSentinel(a, startIdx, middleIdx, endIdx);
//        merge(a, startIdx, middleIdx, endIdx);
    }

    /**
     * 合并两个有序数组
     *
     * @param arr       数组数据源
     * @param leftIdx   左闭区间下标
     * @param middleIdx 中间下标
     * @param rightIdx  右闭区间下标
     */
    private static void merge(int[] arr, int leftIdx, int middleIdx, int rightIdx) {
        // 创建与本次处理数据范围等长的临时数组
        int n = rightIdx - leftIdx + 1;
        int[] tmpArr = new int[n];

        // 同时从头遍历两个数组，对比哪个元素更小，将小元素放入 tmpArr 结果中
        // 挪动 tmpArr 存储下标，挪动 小元素数组 遍历下标

        // 左数组遍历下标
        int i = leftIdx;
        // 右数组遍历下标
        int j = middleIdx + 1;
        // tmpArr 结果数组存储下标
        int t = 0;

        while (i <= middleIdx && j <= rightIdx) {
            if (arr[i] <= arr[j]) {
                tmpArr[t++] = arr[i++];
            } else {
                tmpArr[t++] = arr[j++];
            }
        }

        // 左右数组必有一个已经完全处理完，将另一个未处理完的数据拷贝到 tmpArr
        while (i <= middleIdx) {
            tmpArr[t++] = arr[i++];
        }
        while (j <= rightIdx) {
            tmpArr[t++] = arr[j++];
        }

        // 将 tmpArr排序后的结果拷贝到原始arr
        for (i = leftIdx; i <= rightIdx; i++) {
            arr[i] = tmpArr[i - leftIdx];
        }
    }

    /**
     * 合并两个有序数组，使用sentinel编程技巧
     * <p>
     * sentinel是循环中的边界值，观察我们的对比条件：arr[i] <= arr[j]
     * while循环会导致有一个数组没遍历完，需特殊判断处理
     * 这里可以设 sentinelValue 为 Integer.max ，假设左数组已遍历完，此时左数组已经指向Integer.max，对比左右数据大小时，必定是未完结的右数组进行赋值。
     * 编码中，一个while循环即可完成两个数组的遍历
     *
     * @param arr       数组数据源
     * @param leftIdx   左闭区间下标
     * @param middleIdx 中间下标
     * @param rightIdx  右闭区间下标
     */
    private static void mergeSentinel(int[] arr, int leftIdx, int middleIdx, int rightIdx) {
        int[] leftArr = new int[middleIdx - leftIdx + 1 + 1];
        // 将本次处理范围的数据分别放入左右两个数组
        for (int i = leftIdx; i <= middleIdx; i++) {
            leftArr[i - leftIdx] = arr[i];
        }
        // 末位放sentinel值
        leftArr[middleIdx - leftIdx + 1] = Integer.MAX_VALUE;

        int[] rightArr = new int[rightIdx - middleIdx + 1];
        // 将本次处理范围的数据分别放入左右两个数组
        for (int i = middleIdx + 1; i <= rightIdx; i++) {
            rightArr[i - middleIdx - 1] = arr[i];
        }
        // 末位放sentinel值
        rightArr[rightIdx - middleIdx] = Integer.MAX_VALUE;

        // 左数组遍历下标
        int i = 0;
        // 右数组遍历下标
        int j = 0;
        // arr 结果数组存储下标
        int t = leftIdx;
        while (t <= rightIdx) {
            if (leftArr[i] <= rightArr[j]) {
                arr[t++] = leftArr[i++];
            } else {
                arr[t++] = rightArr[j++];
            }
        }

    }

}
