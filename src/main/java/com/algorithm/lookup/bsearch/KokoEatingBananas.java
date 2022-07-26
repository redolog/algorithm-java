package com.algorithm.lookup.bsearch;

/**
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 * <p>
 * https://leetcode.cn/problems/koko-eating-bananas/
 *
 * @author dragonsong  @date 2022/7/26
 */
public class KokoEatingBananas {
    /*
     * 执行用时：
     * 12 ms
     * , 在所有 Java 提交中击败了
     * 47.51%
     * 的用户
     * 内存消耗：
     * 42.2 MB
     * , 在所有 Java 提交中击败了
     * 54.85%
     * 的用户
     * 通过测试用例：
     * 122 / 122
     */

    /**
     * 设：
     * - len(piles) == n
     * - range(low,high) == m
     * <p>
     * 整体时间复杂度：O(logm * n)
     * 空间复杂度：O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        // 二分边界，最小速度应该是1，最大速度应该是一堆香蕉的最大值
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // 循环 logm 轮
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            long hoursNeed = hoursBySpeed(mid, piles);
            if (hoursNeed == h) {
                // 等值区间是否到达边界
                if (mid == 1 || hoursBySpeed(mid - 1, piles) > h) {
                    return mid;
                }
                // 不是边界，high可以左移
                high = mid - 1;
            } else if (hoursNeed > h) {
                // mid此时不在答案处，low处于非解区间，low可以右移
                low = mid + 1;
            } else {
                // mid此时不在答案处，high处于非解区间，high可以左移
                // hoursNeed < h
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * 复杂度 O(n)
     * 速度越大，所需时间越少
     * hoursBySpeed 是一个递减函数
     */
    private long hoursBySpeed(int speed, int[] piles) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile % speed == 0 ? pile / speed : pile / speed + 1;
            // while(pile>0){
            //     if(pile<speed){
            //         pile-=pile;
            //     }else{
            //         pile-=speed;
            //     }
            //     hours++;
            // }
        }
        return hours;
    }
}
