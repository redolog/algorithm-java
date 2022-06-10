package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * <p>
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 *
 * @author dragonsong  @date 2022/6/9
 */
public class ReversePairs {

    int cnt;

    /**
     * 执行用时：
     * 31 ms
     * , 在所有 Java 提交中击败了
     * 69.49%
     * 的用户
     * 内存消耗：
     * 49 MB
     * , 在所有 Java 提交中击败了
     * 55.76%
     * 的用户
     * 通过测试用例：
     * 139 / 139
     */
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }
        int midIdx = leftIdx + ((rightIdx - leftIdx) >> 1);
        mergeSort(nums, leftIdx, midIdx);
        mergeSort(nums, midIdx + 1, rightIdx);
        merge(nums, leftIdx, midIdx, rightIdx);
    }

    private void merge(int[] nums, int leftIdx, int midIdx, int rightIdx) {
        int[] tmpArr = new int[rightIdx - leftIdx + 1];

        int i = leftIdx;
        int j = midIdx + 1;
        // tmpArr 存储指针
        int t = 0;

        while (i <= midIdx && j <= rightIdx) {
            if (nums[i] <= nums[j]) {
                tmpArr[t++] = nums[i++];
            } else {
                cnt += midIdx - i + 1;
                tmpArr[t++] = nums[j++];
            }
        }

        while (i <= midIdx) {
            tmpArr[t++] = nums[i++];
        }
        while (j <= rightIdx) {
            tmpArr[t++] = nums[j++];
        }

        for (t = 0; t < tmpArr.length; t++) {
            nums[leftIdx + t] = tmpArr[t];
        }
    }

    // 超时！
    public int reversePairsBruteForce(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}
