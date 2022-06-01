package com.algorithm.util;

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

}
