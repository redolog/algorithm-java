package com.algorithm.sort;

import com.algorithm.dataStructure.tree.MaxHeap;
import com.algorithm.util.ArrayUtils;

/**
 * @author dragonsong  @date 2022/5/29
 */
public class HeapSort {

    /*
     * 复杂度分析：
     * 1. 堆排序首先建堆，是原地操作，其次在外部循环中交换最值元素，也是原地。无需额外空间，空间复杂度O(1)；
     * 2. 堆排序不稳定;
     * 3. 时间复杂度：
     *  - 堆排序与数据原有序度无关
     *  - 建堆复杂度取决于树高，n个数据树高为 log2n，公式推导:
     *      - 复杂度= 求和(当前层节点个数 * 当前层高)
     *      - 设：顶节点高为h，中间层节点数为 2^k，对应中间层高为 h-k，倒数第二层高：1，对应节点数为 2^(h-1)
     *      - 对复杂度求和：
     *          - S1 = 2^0 * h + 2^1 * (h-1) + 2^2 * (h-2) + ... + 2^k * (h-k) + ... +2^(h-1) * 1
     *          - S2 = 2* (2^0 * h + 2^1 * (h-1) + 2^2 * (h-2) + ... + 2^k * (h-k) + ... +2^(h-1) * 1)
     *               =           2^1 * h + 2^2 * (h-1) + 2^3 * (h-2) + ... + 2^(k+1) * (h-k) + ... +2^h * 1
     *          - S2为复杂度*2，S2-S1=S= -h + 2^1 + 2^2 + ... + 2^k + ... + 2^(h-1) + 2^h
     *          - 代入等比数列去和公式（q公比，S为和，n表示数据量，Sn=(An*q-A1)/(q-1)）
     *          - 求得 S=-h + (2^h * 2 - 2)/(2 - 1)=-h+2^h
     *          - 其中 h 为 log2n，所以 S= n -h
     *      - 因此建堆复杂度为 O(n)，其中h为常数阶省略
     *  - 我们从查找最大元素开始一直到最小元素，一直迭代n次，执行建堆、替换，后续每一轮堆化操作复杂度与节点高成正比，复杂度 O(logn)
     *  - 因此堆排序时间复杂度为 O(n*logn+n)
     */

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
        while (lastChildIdx > 0) {
            MaxHeap.buildHeap2Down(arr, lastChildIdx);
            ArrayUtils.swap(arr, lastChildIdx, 0);
            --lastChildIdx;
        }

    }

}
