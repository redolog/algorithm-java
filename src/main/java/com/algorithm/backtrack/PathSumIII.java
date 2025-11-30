package com.algorithm.backtrack;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/path-sum-iii/
 *
 * @author songhuilong  @date 2025/11/30
 */
public class PathSumIII {

    public static class PreSumSolution {
        Map<Long, Integer> preSum2Cnt;
        int ans;
        // 防止int加减溢出
        long preSum;

        public int pathSum(TreeNode root, int targetSum) {
            // 记录路径前缀和
            // 判定以当前节点为末端的和为targetSum的路径数
            // 前缀和边界：前缀和为0 存在一条记录，即root还未进入
            preSum2Cnt = new HashMap<>();
            preSum2Cnt.put(0L, 1);
            ans = 0;
            preSum = 0L;
            dfs(root, targetSum);
            return ans;
        }

        private void dfs(TreeNode curr, int targetSum) {
            if (curr == null) {
                return;
            }
            preSum += curr.val;
            // 前缀和查询前序合法路径
            ans += preSum2Cnt.getOrDefault(preSum - targetSum, 0);
            preSum2Cnt.put(preSum, preSum2Cnt.getOrDefault(preSum, 0) + 1);


            dfs(curr.left, targetSum);
            dfs(curr.right, targetSum);

            preSum2Cnt.put(preSum, preSum2Cnt.getOrDefault(preSum, 0) - 1);
            preSum -= curr.val;
        }
    }

    public static class DFSSolution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            // 题目所求个数 = 以当前节点为起点的路径数 + 以左子树为起点的路径数 + 以右子树为起点的路径数
            return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        }

        // 返回以root为根，路径和等于targetSum的数
        private int dfs(TreeNode curr, long targetSum) {
            if (curr == null) {
                return 0;
            }
            int cnt = 0;
            // 后续可能存在抵消为0的段，因此不能阻断
            if (curr.val == targetSum) {
                cnt++;
            }
            cnt += dfs(curr.left, targetSum - curr.val);
            cnt += dfs(curr.right, targetSum - curr.val);
            return cnt;
        }

    }
}
