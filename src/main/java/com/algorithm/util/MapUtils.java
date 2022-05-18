package com.algorithm.util;

public class MapUtils {

    private MapUtils(){}

    public static int capacity(int expectedSize) {
        if (expectedSize < 3) {
            AssertUtils.checkNonnegative(expectedSize, "expectedSize");
            return expectedSize + 1;
        } else {
            return expectedSize < 1073741824 ? (int)((float)expectedSize / 0.75F + 1.0F) : 2147483647;
        }
    }
}
