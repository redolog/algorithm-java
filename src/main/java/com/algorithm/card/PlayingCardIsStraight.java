package com.algorithm.card;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 * <p>
 * https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * @author dragonsong  @date 2022/6/17
 */
public class PlayingCardIsStraight {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 28.36%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 5.24%
     * 的用户
     * 通过测试用例：
     * 203 / 203
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 5.56%
     * 的用户
     * 通过测试用例：
     * 203 / 203
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 78.99%
     * 的用户
     * 通过测试用例：
     * 203 / 203
     * <p>
     * 朴素解法：
     * 对入参排序，因为限定nums.len==5，所以排序时间复杂度其实为 O(1)
     * 遍历，大小王计数，后续元素判断差值，差值大于1开始用大小王填充，否则不是顺子
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int jokerCnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                ++jokerCnt;
            } else {
                int gap = nums[i + 1] - nums[i] - 1;
                // 禁止出现等值牌
                if (gap < 0) {
                    return false;
                }

                if (jokerCnt >= gap) {
                    jokerCnt -= gap;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
