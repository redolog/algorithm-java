package com.algorithm.dataStructure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 加法规则如下:
 * <p>
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 104] 范围内
 * 树的深度在 [1, 104]范围内
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 * <p>
 * https://leetcode.cn/problems/add-one-row-to-tree/
 *
 * @author dragonsong  @date 2022/8/5
 */
public class AddOneRowToTree {

    static class BFS {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                return new TreeNode(val, root, null);
            }

            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root != null) {
                queue.offer(root);
            }

            // 存放前一层节点
            List<TreeNode> list = new ArrayList<>();

            int level = 1;
            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode curr = queue.poll();
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                    if (level == depth - 1) {
                        list.add(curr);
                    }
                }
                if (level == depth - 1) {
                    break;
                }
                level++;
            }
            for (TreeNode node : list) {
                node.left = new TreeNode(val, node.left, null);
                node.right = new TreeNode(val, null, node.right);
            }

            return root;
        }
    }

    static class DFS {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                return new TreeNode(val, root, null);
            }
            dfs(root, 1, val, depth);
            return root;
        }

        public void dfs(TreeNode node, int depth, int val, int targetDepth) {
            if (node == null) {
                return;
            }
            if (depth + 1 == targetDepth) {
                node.left = new TreeNode(val, node.left, null);
                node.right = new TreeNode(val, null, node.right);
                return;
            }
            dfs(node.left, depth + 1, val, targetDepth);
            dfs(node.right, depth + 1, val, targetDepth);
        }
    }


}
