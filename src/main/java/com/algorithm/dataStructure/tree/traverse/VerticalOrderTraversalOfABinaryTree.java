package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 987. 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 * 1 在上面，所以它出现在前面。
 * 5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 * <p>
 * https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * @author dragonsong  @date 2022/7/21
 */
public class VerticalOrderTraversalOfABinaryTree {

    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 98.32%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 39.93%
     * 的用户
     * 通过测试用例：
     * 32 / 32
     */

    /**
     * 结果数组
     */
    List<List<Integer>> ans;
    /**
     * key为横坐标的map，统计节点遍历情况
     * 优先级有序队列中存：x、y、val
     */
    Map<Integer, Queue<int[]>> x2Nodes;
    /**
     * 记录横坐标边界
     */
    int leftMostIdx;
    int rightMostIdx;

    /**
     * 基本思路：
     * 我们记录每个节点的横坐标，以root为0，root.left为-1，root.right为1。题干中要求对同行同列的值进行大小排序，因此我们同时记录纵坐标。
     * 同时，以横坐标为groupByKey组织节点数据
     * 最后，从最左的横坐标开始输出节点数据
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        x2Nodes = new HashMap<>();
        dfs(root, 0, 0);

        ans = new ArrayList<>();
        for (int i = leftMostIdx; i <= rightMostIdx; i++) {
            if (!x2Nodes.containsKey(leftMostIdx)) {
                continue;
            }

            List<Integer> valList = new ArrayList<>();
            Queue<int[]> nodeQueue = x2Nodes.get(i);
            while (!nodeQueue.isEmpty()) {
                valList.add(nodeQueue.poll()[2]);
            }
            ans.add(valList);
        }

        return ans;
    }

    private void dfs(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        x2Nodes.putIfAbsent(x, new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                // 先以y坐标升序
                return a[1] - b[1];
            }
            // 再以val升序
            return a[2] - b[2];
        }));
        Queue<int[]> queue = x2Nodes.get(x);
        queue.offer(new int[]{x, y, node.val});

        leftMostIdx = Math.min(leftMostIdx, x);
        rightMostIdx = Math.max(rightMostIdx, x);

        dfs(node.left, x - 1, y + 1);
        dfs(node.right, x + 1, y + 1);
    }
}
