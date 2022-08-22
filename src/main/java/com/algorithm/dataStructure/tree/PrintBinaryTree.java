package com.algorithm.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 * ["2","",""]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 * ["","2","","","","3",""],
 * ["","","4","","","",""]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 * <p>
 * https://leetcode.cn/problems/print-binary-tree/
 *
 * @author dragonsong  @date 2022/8/22
 */
public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        int m = h(root);
        int h = m - 1;
        int n = (int) (Math.pow(2, h + 1) - 1);
        List<List<String>> ans = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<String> innerList = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                innerList.add("");
            }
            ans.add(innerList);
        }

        dfs(root, 0, (n - 1) / 2, ans, h);

        return ans;
    }

    private void dfs(TreeNode node, int r, int c, List<List<String>> ans, int h) {
        if (node == null) {
            return;
        }
        ans.get(r).set(c, String.valueOf(node.val));
        dfs(node.left, r + 1, (int) (c - Math.pow(2, h - r - 1)), ans, h);
        dfs(node.right, r + 1, (int) (c + Math.pow(2, h - r - 1)), ans, h);
    }

    public int h(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(h(node.left) + 1, h(node.right) + 1);
    }
}
