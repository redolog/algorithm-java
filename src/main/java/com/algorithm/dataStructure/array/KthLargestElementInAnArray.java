package com.algorithm.dataStructure.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * <p>
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 *
 * @author dragonsong  @date 2022/6/10
 */
public class KthLargestElementInAnArray {

    // 本问题中最小堆需要支持的操作：添加元素、查看最小值（堆顶）元素、移除最小元素

    // 从下标1的位置存完全二叉树堆元素
    int[] arr;
    int capacity;
    int size;

    public KthLargestElementInAnArray() {
    }

    public KthLargestElementInAnArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity + 1];
        size = 0;
    }

    /**
     * 添加元素
     */
    public void add(int ele) {
        if (size == capacity) {
            throw new IllegalStateException("最小堆已满");
        }
        ++size;
        arr[size] = ele;
        siftUp();
    }

    /**
     * 查看最小值（堆顶）元素
     */
    public int peekMin() {
        return arr[1];
    }

    /**
     * 移除最小元素
     */
    public void removeMin() {
        arr[1] = arr[size];
        --size;

        siftDown();
    }

    private void siftDown() {
        // 从顶端开始遍历树，检查堆性质
        int parentIdx = 1;
        int leftChildIdx = getLeftChildIdx(parentIdx);
        int rightChildIdx = getRightChildIdx(parentIdx);
        while (leftChildIdx <= size && rightChildIdx <= size) {
            if (arr[parentIdx] <= arr[leftChildIdx] && arr[parentIdx] <= arr[rightChildIdx]) {
                break;
            }
            int smallerIdx = arr[rightChildIdx] <= arr[leftChildIdx] ? rightChildIdx : leftChildIdx;
            swap(arr, smallerIdx, parentIdx);
            parentIdx = smallerIdx;
            leftChildIdx = getLeftChildIdx(parentIdx);
            rightChildIdx = getRightChildIdx(parentIdx);
        }
    }

    private void siftUp() {
        // 从末端往上检查堆性质
        int childIdx = size;
        int parentIdx = getParentIdx(childIdx);
        while (parentIdx >= 1 && arr[parentIdx] > arr[childIdx]) {
            swap(arr, parentIdx, childIdx);
            childIdx = parentIdx;
            parentIdx = getParentIdx(childIdx);
        }
    }


    public int getParentIdx(int childIdx) {
        return childIdx / 2;
    }

    public int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx;
    }

    public int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 81.55%
     * 的用户
     * 内存消耗：
     * 41.5 MB
     * , 在所有 Java 提交中击败了
     * 52.56%
     * 的用户
     * 通过测试用例：
     * 32 / 32
     */
    public int findKthLargestWithMinHeap(int[] nums, int k) {
        KthLargestElementInAnArray minHeap = new KthLargestElementInAnArray(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peekMin()) {
                minHeap.removeMin();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peekMin();
    }

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 61.15%
     * 的用户
     * 内存消耗：
     * 41.8 MB
     * , 在所有 Java 提交中击败了
     * 10.47%
     * 的用户
     * 通过测试用例：
     * 32 / 32
     */
    public int findKthLargestWithPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.60%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 44.91%
     * 的用户
     * 通过测试用例：
     * 32 / 32
     */
    public int findKthLargestWithQuickSortPivot(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }
        // 利用快排思想实现减治：将查询问题集缩小，也就是fail-fast
        int n = nums.length;
        int leftIdx = 0;
        int rightIdx = n - 1;

        // 统一使用下标法
        k = k - 1;

        while (true) {
            // 选择一个pivotVal 基准值，左区间存大于等于pivot的元素，右区间存小于等于pivotVal的元素；
            // 排出pivotVal所在位置后，判断目标位置k在左还是右，下一轮只搜对应区间
            // 从最右侧取一个pivotVal，为了防止极值用例的情况，我们每次选取pivot做一次随机化下标
            int randomIdx = (int) (Math.random() * (rightIdx - leftIdx + 1) + leftIdx);
            swap(nums, randomIdx, rightIdx);

            int pivotVal = nums[rightIdx];

            // leftI遍历从左，rightI遍历从右
            int leftI = leftIdx, rightI = rightIdx - 1;
            while (true) {
                // 从左一直找到小于或者等于pivotVal的位置，待与右侧元素交换
                while (leftI <= rightIdx - 1 && nums[leftI] > pivotVal) {
                    ++leftI;
                }
                // 从右侧一直找到大于或者等于pivotVal的位置，待与左侧元素交换
                while (rightI >= leftIdx && nums[rightI] < pivotVal) {
                    --rightI;
                }

                if (rightI <= leftI) {
                    break;
                }
                // 左侧小于等于的元素 与 右侧大于等于的元素交换
                swap(nums, rightI, leftI);
                --rightI;
                ++leftI;
            }
            swap(nums, leftI, rightIdx);
            // leftI 作为基准值下标
            if (leftI == k) {
                return nums[leftI];
            } else if (leftI < k) {
                leftIdx = leftI + 1;
            } else if (leftI > k) {
                rightIdx = leftI - 1;
            }
        }
    }


    public void swap(int[] arr, int aIdx, int bIdx) {
        if (aIdx == bIdx) {
            return;
        }
        int tmpVal = arr[aIdx];
        arr[aIdx] = arr[bIdx];
        arr[bIdx] = tmpVal;
    }

    public int findKthLargestBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
