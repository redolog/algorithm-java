package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * Medium
 * <p>
 * 8316
 * <p>
 * 163
 * <p>
 * Add to List
 * <p>
 * Share
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * @author dragonsong  @date 2022/5/31
 */
public class BTreeLevelOrderTraversal {

    /**
     * Runtime: 1 ms, faster than 85.90% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 43.4 MB, less than 54.16% of Java online submissions for Binary Tree Level Order Traversal.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> innerList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode qnode = queue.poll();
                if (qnode == null) {
                    continue;
                }
                innerList.add(qnode.val);
                if (qnode.left != null) {
                    queue.offer(qnode.left);
                }
                if (qnode.right != null) {
                    queue.offer(qnode.right);
                }
            }
            ans.add(innerList);
        }
        return ans;
    }
}
