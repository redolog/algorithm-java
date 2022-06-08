package com.algorithm.util;

import java.util.stream.IntStream;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static boolean isEmpty(int[] a) {
        return a == null || a.length == 0;
    }

    public static boolean isEmpty(Object[] a) {
        return a == null || a.length == 0;
    }

    public static boolean dontNeedSort(int[] a) {
        return isEmpty(a) || a.length == 1;
    }

    public static boolean dontNeedSwap(int[] a) {
        return isEmpty(a) || a.length < 2;
    }

    public static void swap(int[] array, int aIdx, int bIdx) {
        if (dontNeedSwap(array) || aIdx == bIdx) {
            return;
        }

        int tmp = array[aIdx];
        array[aIdx] = array[bIdx];
        array[bIdx] = tmp;
    }

    public static boolean dontNeedEquals(int[] arr) {
        return null == arr || arr.length < 2;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 基于入参，构建一个随机数组
     *
     * @param maxLen 数组长度最大，[1,manLen]内随机
     * @param maxVal 数组元素值最大，[1,maxVal]内随机
     * @return 随机数组
     */
    public static int[] createArrayByRandomLenAndVal(int maxLen, int maxVal) {
        int[] arr = new int[NumberUtils.randomInt(maxLen)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = NumberUtils.randomInt(maxVal);
        }
        return arr;
    }

    public static int[] createFullyOrderedArray(int size) {
        if (size < 1) {
            return new int[0];
        }
        return IntStream.range(0, size).toArray();
    }

    /**
     * 先按size生成完全有序的数组，再按照 swapTimes 随机打乱数组
     *
     * @param size      数组大小
     * @param swapTimes 随机交换次数
     * @return 按 swapTimes 次数成反比的近有序数组
     */
    public static int[] createNearlyOrderedArray(int size, int swapTimes) {
        if (size < 1) {
            return new int[0];
        }
        int[] arr = createFullyOrderedArray(size);

        for (int i = 0; i < swapTimes; i++) {
            int aIdx = NumberUtils.randomIndex(size);
            int bIdx = NumberUtils.randomIndex(size);
            swap(arr, aIdx, bIdx);
        }
        return arr;
    }

    public static boolean nearlyEquals(int precision, int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length < precision || arr2 == null || arr2.length < precision || arr1.length != arr2.length) {
            return false;
        }
        int notEqualCnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            notEqualCnt += arr1[i] == arr2[i] ? 0 : 1;
        }
        return notEqualCnt <= 2 * precision;
    }

    public static void printArr(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        System.out.println();
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

}
