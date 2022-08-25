package com.algorithm.dataStructure.array;

/**
 * https://leetcode.cn/problems/count-elements-with-strictly-smaller-and-greater-elements/
 *
 * @author dragonsong  @date 2022/8/25
 */
public class CountElementsWithStrictlySmallerAndGreaterElements {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：只记录了max、min信息，O(1)
     */
    public int countElements(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max == min) {
            return 0;
        }
        // 维护最大最小值对应计数
        int minCnt = 0, maxCnt = 0;
        for (int num : nums) {
            if (num == min) {
                minCnt++;
            }
            if (num == max) {
                maxCnt++;
            }
        }
        return n - minCnt - maxCnt;
    }
}
