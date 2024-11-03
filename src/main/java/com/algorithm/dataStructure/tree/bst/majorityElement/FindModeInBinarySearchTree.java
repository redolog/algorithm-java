package com.algorithm.dataStructure.tree.bst.majorityElement;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 *
 * @author songhuilong  @date 2024/11/3
 */
public class FindModeInBinarySearchTree {

    public static class MapCntSolution {
        // 维护每个元素对应的出现次数
        Map<Integer, Integer> val2Cnt;
        // 维护最多的次数
        int maxCnt;

        public int[] findMode(TreeNode root) {
            val2Cnt = new HashMap<>();
            maxCnt = 0;
            dfs(root);

            List<Integer> majorityList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : val2Cnt.entrySet()) {
                if (entry.getValue() == maxCnt) {
                    majorityList.add(entry.getKey());
                }
            }

            int[] ans = new int[majorityList.size()];
            int i = 0;
            for (int majority : majorityList) {
                ans[i++] = majority;
            }
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            int val = node.val;
            int newCnt = val2Cnt.getOrDefault(val, 0) + 1;
            maxCnt = Math.max(maxCnt, newCnt);
            val2Cnt.put(val, newCnt);
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static class InOrderBSTSolution {
        // 利用BST中序遍历有序的特性，进行有序遍历
        // 维护每个段的元素值，segmentVal
        int segmentVal;
        // 维护每个段的元素出现次数，cnt
        int cnt;
        // 维护所有端元素的最大出现次数，maxCnt
        int maxCnt;
        // 使用一个列表维护答案，当最大出现次数更新时，重置列表
        List<Integer> ans;

        public int[] findMode(TreeNode root) {
            segmentVal = root.val;
            cnt = 0;
            maxCnt = 0;
            ans = new LinkedList<>();

            inOrderDFS(root);

            int[] ansArr = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                ansArr[i] = ans.get(i);
            }
            return ansArr;
        }

        // 中序遍历，中间每个节点真实的判断与处理一个有序的数组元素一样
        private void inOrderDFS(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrderDFS(node.left);
            handlePerNode(node);
            inOrderDFS(node.right);
        }

        // 有序遍历时，处理每个元素
        private void handlePerNode(TreeNode node) {
            int nodeVal = node.val;
            if (nodeVal == segmentVal) {
                // 连续的段，更新计数
                cnt++;
            } else {
                // 更新为一个新的连续的段
                segmentVal = nodeVal;
                cnt = 1;
            }
            // 更新出现最多的元素
            if (cnt == maxCnt) {
                ans.add(nodeVal);
            }
            // 重置最大计数
            if (cnt > maxCnt) {
                maxCnt = cnt;
                ans.clear();
                ans.add(nodeVal);
            }
        }
    }
}
