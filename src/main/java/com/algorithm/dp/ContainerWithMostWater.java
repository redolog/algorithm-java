package com.algorithm.dp;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * @author DragonSong  @date 2020/12/25
 * @link {https://leetcode-cn.com/problems/container-with-most-water/}
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        return twoCursorVersion(height);
    }

    /**
     * 给定一个集合，快速查询极值的本质：单次搜索动作，跳过不在目标范围内数据越多，整体操作越快，效率越高，时间复杂度越低。
     * - 有序集合：BinarySearch/SkipList
     * - 此题属于无序集合的范畴
     *
     * @link {https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/}
     */
    private int twoCursorVersion(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            maxArea = Math.max(maxArea, Math.min(leftVal, rightVal) * (right - left));
            if (leftVal <= rightVal) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    private int rudeVersion(int[] height) {
        int maxArea = 0;
        for (int left = 0; left < height.length - 1; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int minHeight = Math.min(height[left], height[right]);
                int width = right - left;
                int area = minHeight * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
