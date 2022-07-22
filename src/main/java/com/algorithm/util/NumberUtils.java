package com.algorithm.util;

import java.util.Arrays;
import java.util.List;

public class NumberUtils {

    private NumberUtils() {
    }

    /**
     * 近似等于，判定数组元素与首个元素的差，是否在精度内
     *
     * @param precision 精度
     * @param nums      待判断数组
     * @return 元素-首个元素的差绝对值在精度内返回true
     */
    public static boolean nearlyEquals(int precision, int... nums) {
        if (ArrayUtils.dontNeedEquals(nums)) {
            return true;
        }
        int avg = Arrays.stream(nums).sum() / nums.length;

        for (int i = 1; i < nums.length; i++) {
            if (MathUtils.abs(nums[i] - avg) > precision * 10) {
                return false;
            }
        }
        return true;
    }

    public static boolean nearlyEquals(int precision, List<Integer> nums) {
        int first = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            if (MathUtils.abs(nums.get(i) - first) > precision) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param maxInt 最大边界
     * @return 返回 [1,maxInt] 内随机整数
     */
    public static int randomInt(int maxInt) {
        return (int) (Math.random() * maxInt) + 1;
    }

    /**
     * @param maxInt 最大边界
     * @return 返回 [0,maxInt) 内随机整数
     */
    public static int randomIndex(int maxInt) {
        return (int) (Math.random() * maxInt);
    }

    /**
     * @param leftIdx  左闭区间下标
     * @param rightIdx 右闭区间下标
     * @return 返回[leftIdx, rightIdx] 内随机整数下标
     */
    public static int randomIndexWithRange(int leftIdx, int rightIdx) {
        return (int) (Math.random() * (rightIdx - leftIdx + 1) + leftIdx);
    }
}
