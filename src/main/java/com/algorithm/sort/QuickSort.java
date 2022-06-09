package com.algorithm.sort;

import com.algorithm.util.ArrayUtils;
import com.algorithm.util.NumberUtils;

/**
 * 快速排序
 *
 * @author dragonsong  @date 2022/5/23
 */
public class QuickSort {

    /*
     * 复杂度分析：
     * 1. 快排先分区再递归执行，分区是原地操作，无额外内存占用，递归执行也无需额外空间，空间复杂度O(1)；
     * 2. 分区涉及交换操作，如果数组中有两个相同的元素，比如序列 6，8，7，6，3，5，9，4，在经过第一次分区操作之后，两个 6 的相对先后顺序就会改变。所以，快排并不是稳定的排序算法;
     * 3. 时间复杂度：
     *  - 最好情况 pivot每次分区将数据均等二分，分区 log2n次，每轮分区内遍历n个数据进行数据分组，时间复杂度 O(nlogn)；
     *  - 最坏情况 pivot每次分区将数据分为1个数据、剩余数据，分区 n-1 次，每轮分区内遍历n个数据进行数据分组，时间复杂度 O(n^2)；
     *  - 平均情况 我们使用回溯法、分析递归执行树的方式估算平均时间复杂度：
     *      - 我们假设每次分区比如为 1:9
     *      - 则最左侧小区间，每一轮分区都获得数据集的 1/10 数据量，而树高则代表了数据集处理的时间复杂度，第一轮分区，左侧数据为 n/10，第二轮分区，左侧数据为 n/10^2，因此轮数即为树高
     *      - 当 n/10^x == 1 也就是数据集为1不需要排序时，树停止递归，我们开始回溯！计算可得 x=log10n
     *      - 同理，我们可得最右侧最高树的树高为：log10/9 n 底数为10/9
     *      - 也就是说 我们这棵二叉树的树高平均在 [log10n,log10/9 n] 范围内
     *      - 根据大O算法的指导思想，我们去掉常数阶、低阶，可得，时间复杂度为 O(n*logn)
     *      - 同时注意，大O算法只描述算法随着数据集规模上升时，时间、空间成本变化的趋势，并不代表绝对值，实际工程中需结合测试，得到具体的运行数据
     */

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

    public static void quickSortThreeWays(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSortThreeWays(arr, 0, arr.length - 1);
    }

    private static void quickSortThreeWays(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }
        ArrayUtils.swap(arr,rightIdx,NumberUtils.randomIndexWithRange(leftIdx,rightIdx));

        // 对比基准值
        int pivotVal = arr[rightIdx];

        // 将数组分为三个区域：右侧大于、左侧小于、中间等于
        // [gt,rightIdx] 大于，gt指向当前大于等于的区间，最后处理rightIdx位置
        int gt = rightIdx;
        // [leftIdx,lt] 小于，lt指向当前小于的区间
        int lt = leftIdx - 1;
        // [lt+1,eg) 等于 右开区间，保证初始化时区间仍然成立 i指向遍历位置，即下一个处理的位置
        int i = lt + 1;

        while (i < gt) {
            if (arr[i] < pivotVal) {
                // arr[i] 放到lt+1
                ArrayUtils.swap(arr, i, ++lt);
                ++i;
            } else if (arr[i] == pivotVal) {
                ++i;
            } else {
                ArrayUtils.swap(arr, i, --gt);
            }
        }
        // 将rightIdx pivotVal放到中间区域
        ArrayUtils.swap(arr, rightIdx, gt);

        // 分别对大区间、小区间执行快排
        quickSortThreeWays(arr, leftIdx, lt);
        quickSortThreeWays(arr, gt, rightIdx);
    }

    private static void quickSort(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }
//        int pivotIdx = partitionPengdi(arr, leftIdx, rightIdx);
//        quickSort(arr, leftIdx, pivotIdx - 1);
//        // 使用pengdi版本算法，在右区间需传入pivotIdx
//        quickSort(arr, pivotIdx, rightIdx);

        if (rightIdx - leftIdx < 15) {
            ShellSort.insertSort(arr, leftIdx, rightIdx, rightIdx - leftIdx + 1);
            return;
        }

        int pivotIdx = partitionOptimized(arr, leftIdx, rightIdx);
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
                    ArrayUtils.swap(arr, i++, j++);
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

    // 优化partition，数组中等值元素过多时，原来的算法会导致左侧小区间过大，分区不平衡，导致算法性能不佳
    // 使用两个遍历指针，往中间靠拢。左指针寻找>待查找值的元素，右指针寻找<待查找值的元素，这样两边找到等值元素后都会保留在对应侧区间。
    private static int partitionOptimized(int[] arr, int leftIdx, int rightIdx) {
        // 避免每次最右侧元素过大或者过小：导致分区不平衡，我们随机一下
        int randomIdx = NumberUtils.randomIndexWithRange(leftIdx, rightIdx);
        ArrayUtils.swap(arr, rightIdx, randomIdx);
        // 待查找值，我们取最右侧元素
        int val = arr[rightIdx];

        // 两个遍历指针
        int i = leftIdx;
        int j = rightIdx - 1;

        while (true) {
            // i、j 元素比较大小时，不能使用 = ，否则也会造成左右区间不平衡，等值元素左右侧均可放，所以对等值元素做交换处理
            while (i < rightIdx && arr[i] < val) {
                ++i;
            }
            while (j >= leftIdx && arr[j] > val) {
                --j;
            }
            if (i >= j) {
                break;
            }
            ArrayUtils.swap(arr, i, j);
            ++i;
            --j;
        }
        // 循环终止时，j到了 小区间，i到了大区间
        ArrayUtils.swap(arr, i, rightIdx);
        return i;
    }

    /**
     * pivot 可考虑取中间位置的值，左右下标同时向中间靠拢
     */
    private static int partitionPengdi(int[] arr, int leftIdx, int rightIdx) {
        int middleValue = arr[leftIdx + ((rightIdx - leftIdx) >> 1)];
        while (leftIdx <= rightIdx) {
            while (arr[leftIdx] < middleValue) {
                leftIdx++;
            }
            while (arr[rightIdx] > middleValue) {
                rightIdx--;
            }
            if (leftIdx <= rightIdx) {
                ArrayUtils.swap(arr, leftIdx, rightIdx);
                leftIdx++;
                rightIdx--;
            }
        }
        return leftIdx;

    }
}
