package com.algorithm.util;

public class ArrayUtils {
    private ArrayUtils(){}

    public static boolean isEmpty(int[] a){
        return a == null || a.length == 0;
    }
    public static boolean dontNeedSort(int[] a){
        return isEmpty(a) || a.length == 1;
    }

}
