package com.algorithm.dataStructure.array;

/**
 * 给定有序可重复int数组，查找目标值出现次数
 * 20:28:07 对方: int func(int []array, int target)
 * 20:28:33 对方: [1,2,2,3,5,6,6,8,]
 *
 * @author DragonSong  @date 2021/3/25
 */
public class TargetOccurrenceInArray {

    public static int targetOccurrenceInArray(int[] arr, int target) {
        int lastIndex = arr.length - 1;

        // 左侧元素查找
        int leftFirstIndex = 0;
        int leftLastIndex = lastIndex;

        while (leftFirstIndex < leftLastIndex) {
            // 二分
            int middle = leftFirstIndex + (leftLastIndex - leftFirstIndex) / 2;
            if (arr[middle] < target) {
                // 小了，区间右移
                leftFirstIndex = middle + 1;
            } else {
                // 大了，区间左移
                leftLastIndex = middle;
            }
        }

        // 右侧元素查找
        int rightFirstIndex = leftLastIndex + 1;
        int rightLastIndex = lastIndex;

        if (rightLastIndex <= rightFirstIndex + 1 && arr[rightLastIndex] > target) {
            rightLastIndex = rightFirstIndex;
        }

        while (rightLastIndex > rightFirstIndex + 1) {
            // 二分
            int middle = rightFirstIndex + (rightLastIndex - rightFirstIndex) / 2;
            if (arr[middle] > target) {
                // 大了，区间左移
                rightLastIndex = middle - 1;
            } else {
                // 小了，区间右移
                rightFirstIndex = middle;
            }
        }

        // 最右相等元素下标 - 最左相等元素下标
        return rightLastIndex - leftFirstIndex + 1;
    }

    public static void main(String[] args) {
        System.out.println(targetOccurrenceInArray(new int[]{1, 2, 2, 3, 5, 6, 6, 8}, 2));
        System.out.println(targetOccurrenceInArray(new int[]{1, 2, 2, 3, 5, 6, 6, 8}, 8));
        System.out.println(targetOccurrenceInArray(new int[]{1, 2, 2, 3, 5, 6, 6, 8}, 6));
        System.out.println(targetOccurrenceInArray(new int[]{1, 2, 2, 3, 5, 6, 6, 8}, 5));
    }
}
