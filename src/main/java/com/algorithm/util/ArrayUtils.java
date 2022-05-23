package com.algorithm.util;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static boolean isEmpty(int[] a) {
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

}
