package com.algorithm.sort;

/**
 * 希尔排序：
 * 针对插入排序的优化版本。由D.L.Shell于1959年提出，又叫 Diminishing Increment Sort 递减增量排序。
 *
 * @author dragonsong  @date 2022/6/8
 */
public class ShellSort {

    /**
     * 回顾下插入排序：
     * 1. 遍历数组，将数组分为左侧已排序区，右侧未排序区；
     * 2. 当前元素向左遍历，判断当前元素与数组遍历位置元素大小关系，如果当前元素小，交换两个元素，当前元素持续左移；
     * 3. 元素比较碰到遍历元素小于当前元素时，停止本轮比较、插入；
     * 4. 持续挪动当前元素，右移，持续上述操作；
     * <p>
     * 希尔排序基本思想：
     * 1. 先将数组一分为二，将每个子数组首项视作一个数组，做插入排序处理；
     * 2. 接着子数组再一分为二，继续处理每个子数组；
     * 3. 一直拆分数组，直到子数组 size==1；
     * 4. 此时整个数组已经有序；
     * <p>
     * 相比时间复杂度为 O(n^2) 的插入排序而言，希尔排序主要借助了插入排序在数据有序度较高的情况性能较高的特性。
     * 前期主要对数组进行有限次数的局部有序化。
     * 逐步缩小子集规模，最后数组整体有序。
     *
     * @param arr 待排序数组
     */
    public void shellSort(int[] arr) {
        int n = arr.length;
        for (int groupSize = n / 2; groupSize >= 1; groupSize /= 2) {
            for (int startIdx = 0; startIdx < n; startIdx += groupSize) {
                int curr = arr[startIdx];
                int currIdx = startIdx - groupSize;
                for (; currIdx >= 0; currIdx -= groupSize) {
                    if (arr[currIdx] <= curr) {
                        break;
                    }
                    arr[currIdx + groupSize] = arr[currIdx];
                }
                // 插入
                arr[currIdx + groupSize] = curr;
            }
        }
    }

    public void insertSort(int[] arr) {
        insertSort(arr, 0, arr.length - 1, arr.length);
    }

    public void insertSort(int[] arr, int groupStartIdx, int groupEndIdx, int size) {
        for (int startIdx = groupStartIdx; startIdx <= groupEndIdx; startIdx++) {
            int curr = arr[startIdx];
            int currIdx = startIdx - 1;
            for (; currIdx >= groupStartIdx; currIdx--) {
                if (curr < arr[currIdx]) {
                    arr[currIdx + 1] = arr[currIdx];
                } else {
                    break;
                }
            }
            arr[currIdx + 1] = curr;
        }
    }

//    public void insertSort2(int[] arr) {
//        for (int startIdx = 1; startIdx < arr.length; startIdx++) {
//            // 本轮待比较的基准值
//            int curr = arr[startIdx];
//            // i表示遍历下标
//            for (int i = startIdx - 1; i >= 0; i--) {
//                if (arr[i] <= curr) {
//                    continue;
//                }
//                ArrayUtils.swap(arr, i, i + 1);
//            }
//        }
//    }
}
