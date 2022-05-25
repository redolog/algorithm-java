package com.algorithm.util;

public class NumberUtils {

    private NumberUtils() {
    }

    public static boolean nearlyEquals(int precision, int... nums) {
        if (ArrayUtils.dontNeedEquals(nums)) {
            return true;
        }
        int first = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (MathUtils.abs(nums[i] - first) > precision) {
                return false;
            }
        }
        return true;
    }
}
