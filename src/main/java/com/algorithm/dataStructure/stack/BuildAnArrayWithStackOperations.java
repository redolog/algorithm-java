package com.algorithm.dataStructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array target and an integer n.
 * <p>
 * You have an empty stack with the two following operations:
 * <p>
 * "Push": pushes an integer to the top of the stack.
 * "Pop": removes the integer on the top of the stack.
 * You also have a stream of the integers in the range [1, n].
 * <p>
 * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:
 * <p>
 * If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
 * If the stack is not empty, pop the integer at the top of the stack.
 * If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
 * Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
 * <p>
 * <p>
 * <p>
 * https://leetcode.cn/problems/build-an-array-with-stack-operations/
 *
 * @author DragonSong  @date 2022/10/15
 */
public class BuildAnArrayWithStackOperations {

    /**
     * 模拟：
     * 时间复杂度：最差会完整遍历n大小的stream，O(n)
     * 空间复杂度：除答案空间无额外空间开销，O(1)
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        // i遍历stream，j遍历target
        for (int i = 0, j = 0; i < n; i++) {
            // target已构建完，跳出
            if (j >= target.length) {
                break;
            }
            // i+1 表示stream当前元素值
            ans.add("Push");

            if (i + 1 != target[j]) {
                ans.add("Pop");
            } else {
                j++;
            }
        }
        return ans;
    }
}
