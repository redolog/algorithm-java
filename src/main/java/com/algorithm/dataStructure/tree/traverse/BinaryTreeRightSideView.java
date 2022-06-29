package com.algorithm.dataStructure.tree.traverse;


import com.algorithm.dataStructure.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 *
 * @author dragonsong  @date 2022/6/29
 */
public class BinaryTreeRightSideView {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 81.54%
     * 的用户
     * 内存消耗：
     * 40.4 MB
     * , 在所有 Java 提交中击败了
     * 10.95%
     * 的用户
     * 通过测试用例：
     * 215 / 215
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> ansList = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) {
                    ansList.add(node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return ansList;
    }
}
