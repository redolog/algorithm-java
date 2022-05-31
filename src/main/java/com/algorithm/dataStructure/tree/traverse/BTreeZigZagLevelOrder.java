package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author dragonsong  @date 2022/5/30
 */
public class BTreeZigZagLevelOrder {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 72.18%
     * 的用户
     * 内存消耗：
     * 40 MB
     * , 在所有 Java 提交中击败了
     * 74.53%
     * 的用户
     * 通过测试用例：
     * 33 / 33
     */
    @SuppressWarnings("unchecked")
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 奇数层从左向右，偶数层相反
        boolean oddLevel = true;
        while (!queue.isEmpty()) {

            Deque<Integer> innerList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr == null) {
                    continue;
                }

                queue.offer(curr.left);
                queue.offer(curr.right);

                if (oddLevel) {
                    innerList.offerLast(curr.val);
                } else {
                    innerList.offerFirst(curr.val);
                }
            }
            if (!innerList.isEmpty()) {
                ans.add((List<Integer>) innerList);
            }
            oddLevel = !oddLevel;
        }

        return ans;
    }

}
