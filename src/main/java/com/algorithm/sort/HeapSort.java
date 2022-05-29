package com.algorithm.sort;

import com.algorithm.dataStructure.heap.MaxHeap;
import com.algorithm.util.ArrayUtils;

/**
 * @author dragonsong  @date 2022/5/29
 */
public class HeapSort {

    /**
     * 借助堆结构排序：
     * 1. 构建一个堆化数组
     * 2. 每次我们取堆顶最大或最小元素
     * 3. 将剩余元素继续堆化，重复2.
     *
     * @param arr 待排序数组
     */
    public static void heapSort(int[] arr) {
        if (ArrayUtils.dontNeedSort(arr)) {
            return;
        }

        int lastChildIdx = arr.length - 1;
        MaxHeap.buildHeap2Down(arr);

        while (lastChildIdx > 0) {
            ArrayUtils.swap(arr, lastChildIdx, 0);
            --lastChildIdx;
            MaxHeap.buildHeap2Down(arr, lastChildIdx);
        }

    }

}
