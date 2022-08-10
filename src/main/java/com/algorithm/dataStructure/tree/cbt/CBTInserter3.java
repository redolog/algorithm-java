package com.algorithm.dataStructure.tree.cbt;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author dragonsong  @date 2022/8/10
 */
public class CBTInserter3 {

    TreeNode root;
    // 插入队列
    Deque<TreeNode> queue;

    public CBTInserter3(TreeNode root) {
        this.root = root;
        queue = new ArrayDeque<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            // 可以插入子节点的才入队
            if (curr.left == null || curr.right == null) {
                queue.offer(curr);
            }

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
    }

    // O(1)
    public int insert(int val) {
        TreeNode first = queue.peekFirst();
        TreeNode newNode = new TreeNode(val);
        queue.offer(newNode);
        if (first.left == null) {
            first.left = newNode;
        } else {
            // 将first从插入队列删除
            queue.removeFirst();
            first.right = newNode;
        }
        return first.val;
    }

    public TreeNode get_root() {
        return root;
    }

}
