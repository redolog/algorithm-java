package com.algorithm.backtrack;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * https://leetcode.cn/problems/path-sum-ii/
 *
 * @author dragonsong  @date 2022/7/20
 */
public class PathSumII {

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.99%
     * 的用户
     * 内存消耗：
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 58.91%
     * 的用户
     * 通过测试用例：
     * 115 / 115
     */

    List<List<Integer>> ans;

    Deque<Integer> innerQueue;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        innerQueue = new ArrayDeque<>();
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        innerQueue.offerLast(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            ans.add(new ArrayList<>(innerQueue));
            return;
        }

        dfs(node.left, targetSum - node.val);
        if (node.left != null) {
            innerQueue.pollLast();
        }
        dfs(node.right, targetSum - node.val);
        if (node.right != null) {
            innerQueue.pollLast();
        }
    }
}
