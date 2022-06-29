package com.algorithm.dataStructure.tree.traverse;


import com.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * <p>
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * @author dragonsong  @date 2022/6/29
 */
public class TreeLevelOrder {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 97.76%
     * 的用户
     * 内存消耗：
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 39.96%
     * 的用户
     * 通过测试用例：
     * 34 / 34
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                ansList.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        int[] ansArr = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArr[i] = ansList.get(i);
        }
        return ansArr;
    }
}
