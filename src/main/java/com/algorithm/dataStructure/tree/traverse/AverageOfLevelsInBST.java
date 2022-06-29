package com.algorithm.dataStructure.tree.traverse;


import com.algorithm.dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * <p>
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 *
 * @author dragonsong  @date 2022/6/29
 */
public class AverageOfLevelsInBST {

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 94.78%
     * 的用户
     * 内存消耗：
     * 43.4 MB
     * , 在所有 Java 提交中击败了
     * 5.61%
     * 的用户
     * 通过测试用例：
     * 66 / 66
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add((double) sum / size);
        }
        return ans;
    }
}
