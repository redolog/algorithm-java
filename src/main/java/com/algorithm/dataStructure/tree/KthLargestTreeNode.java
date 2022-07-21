package com.algorithm.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * @author dragonsong  @date 2022/7/21
 */
public class KthLargestTreeNode {

    static class ListSolution {
        public int kthLargest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return k > list.size() ? -1 : list.get(k - 1);
        }

        private void inOrder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            inOrder(node.right, list);

            list.add(node.val);

            inOrder(node.left, list);
        }
    }

    static class CntSolution {
        /*
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 41 MB
         * , 在所有 Java 提交中击败了
         * 80.57%
         * 的用户
         * 通过测试用例：
         * 91 / 91
         */

        /**
         * 结果
         */
        int ans;
        /**
         * k计数
         */
        int k;

        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            inOrder(root);
            return ans;
        }

        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.right);
            // 代表处理了node节点
            --k;
            if (0 == k) {
                ans = node.val;
                return;
            }

            inOrder(node.left);
        }
    }


}
