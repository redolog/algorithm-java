package com.algorithm.dataStructure.tree.cbt;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 * <p>
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数量范围为 [1, 1000]
 * 0 <= Node.val <= 5000
 * root 是完全二叉树
 * 0 <= val <= 5000
 * 每个测试用例最多调用 insert 和 get_root 操作 104 次
 * <p>
 * https://leetcode.cn/problems/complete-binary-tree-inserter/
 *
 * @author dragonsong  @date 2022/8/10
 */
public class CBTInserter {
    // 根
    TreeNode root;
    // 最后一层层数：深度
    int depth;
    // 节点个数
    int cnt;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.depth = -1;
        this.cnt = 0;
        if (root == null) {
            return;
        }

        this.cnt = 1;
        // 空间复杂度 O(n)
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 时间复杂度 O(n)
        while (!queue.isEmpty()) {
            this.depth++;

            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                    cnt++;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    cnt++;
                }
            }
        }
    }

    public boolean isLastLevelFull(int cnt) {
        // cnt+1节点个数为2的次幂时，说明最后一层满了，n只有一个高位为1，而此时 n-1 二进制中表示为低位均为1，&之后1都会消掉
        return (cnt & (cnt + 1)) == 0;
    }

    // O(1)
    public int insert(int val) {
        // O(n)
        TreeNode parent = getInsertParent();

        while (true) {
            if (parent.left == null) {
                parent.left = new TreeNode(val);
                break;
            }
            if (parent.right == null) {
                parent.right = new TreeNode(val);
                break;
            }
        }
        cnt++;
        if (!isLastLevelFull(cnt) && isLastLevelFull(cnt - 1)) {
            depth++;
        }
        return parent.val;
    }

    private TreeNode getInsertParent() {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {

            for (int i = q.size(); i > 0; i--) {

                TreeNode curr = q.poll();
                if (isLastLevelFull(cnt) && depth == this.depth) {
                    return curr;
                }
                if (!isLastLevelFull(cnt) && depth == this.depth - 1 && (curr.left == null || curr.right == null)) {
                    return curr;
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;

        }
        return null;
    }

    public TreeNode get_root() {
        return root;
    }

}
