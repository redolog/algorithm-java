package com.algorithm.dataStructure.tree.traverse;


import com.algorithm.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 * <p>
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 *
 * @author dragonsong  @date 2022/6/29
 */
public class FindLargestValueInEachTreeRow {

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 76.78%
     * 的用户
     * 内存消耗：
     * 41.8 MB
     * , 在所有 Java 提交中击败了
     * 30.86%
     * 的用户
     * 通过测试用例：
     * 78 / 78
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ansList = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ansList.add(max);
        }
        return ansList;
    }

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 9.59%
     * 的用户
     * 内存消耗：
     * 41.5 MB
     * , 在所有 Java 提交中击败了
     * 77.77%
     * 的用户
     * 通过测试用例：
     * 78 / 78
     */
    public List<Integer> largestValuesWithDFS(TreeNode root) {
        Map<Integer, Integer> idx2Max = new TreeMap<>(Comparator.naturalOrder());

        dfs(root, 0, idx2Max);

        return new ArrayList<>(idx2Max.values());
    }

    private void dfs(TreeNode node, int level, Map<Integer, Integer> idx2Max) {
        if (node == null) {
            return;
        }
        idx2Max.put(level, Math.max(node.val, idx2Max.getOrDefault(level, Integer.MIN_VALUE)));

        ++level;
        dfs(node.left, level, idx2Max);
        dfs(node.right, level, idx2Max);
    }
}
