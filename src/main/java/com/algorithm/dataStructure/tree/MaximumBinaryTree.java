package com.algorithm.dataStructure.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/maximum-binary-tree/
 *
 * @author dragonsong  @date 2022/8/20
 */
public class MaximumBinaryTree {

    /**
     * 单调递减栈
     */
    static class MonotonousDecreaseStack {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            // 维护单调递减的节点
            Deque<TreeNode> stk = new ArrayDeque<>();
            for (int num : nums) {
                TreeNode curr = new TreeNode(num);
                // num比前序节点值更大时，取出前序节点，设置当前节点的左子
                while (!stk.isEmpty() && stk.peek().val < num) {
                    curr.left = stk.pollFirst();
                }
                // 此时curr一定比栈中前序节点更小
                // 设置上一个节点的右子节点。
                if (!stk.isEmpty()) {
                    stk.peekFirst().right = curr;
                }
                // 当前比前序更小的节点入栈
                stk.offerFirst(curr);
            }
            // 最终最大元素在栈底
            return stk.peekLast();
        }
    }

    static class Recursion {
        int[] nums;

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            this.nums = nums;
            return recurse(0, nums.length - 1);
        }

        private TreeNode recurse(int l, int r) {
            int maxIdx = getMaxIdx(l, r);
            if (maxIdx == -1) {
                return null;
            }
            TreeNode curr = new TreeNode(nums[maxIdx]);
            curr.left = recurse(l, maxIdx - 1);
            curr.right = recurse(maxIdx + 1, r);
            return curr;
        }

        private int getMaxIdx(int l, int r) {
            if (l > r || l < 0 || r >= nums.length) {
                return -1;
            }

            int maxIdx = l;
            l++;
            while (l <= r) {
                if (nums[l] > nums[maxIdx]) {
                    maxIdx = l;
                }
                l++;
            }
            return maxIdx;
        }
    }


}
