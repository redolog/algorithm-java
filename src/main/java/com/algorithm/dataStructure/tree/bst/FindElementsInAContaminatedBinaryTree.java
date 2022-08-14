package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1261. 在受污染的二叉树中查找元素
 * 给出一个满足下述规则的二叉树：
 * <p>
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * <p>
 * 请你先还原二叉树，然后实现 FindElements 类：
 * <p>
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * 输出：
 * [null,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * 输出：
 * [null,true,true,false]
 * 解释：
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * 输出：
 * [null,true,false,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 * <p>
 * <p>
 * 提示：
 * <p>
 * TreeNode.val == -1
 * 二叉树的高度不超过 20
 * 节点的总数在 [1, 10^4] 之间
 * 调用 find() 的总次数在 [1, 10^4] 之间
 * 0 <= target <= 10^6
 * <p>
 * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/
 *
 * @author dragonsong  @date 2022/8/14
 */
public class FindElementsInAContaminatedBinaryTree {

    static class FindElements {

        TreeNode newRoot;

        public FindElements(TreeNode root) {
            newRoot = new TreeNode(0);
            newRoot.left = rebuild(newRoot, root.left, true);
            newRoot.right = rebuild(newRoot, root.right, false);
        }

        private TreeNode rebuild(TreeNode parent, TreeNode node, boolean left) {
            if (node == null) {
                return null;
            }
            TreeNode curr = new TreeNode();
            curr.val = left ? 2 * parent.val + 1 : 2 * parent.val + 2;
            curr.left = rebuild(curr, node.left, true);
            curr.right = rebuild(curr, node.right, false);
            return curr;
        }

        public boolean find(int target) {
            if (target < 0) return false;
            return find(newRoot, target);
        }

        private boolean find(TreeNode node, int target) {
            if (node == null) {
                return false;
            }
            return target == node.val || find(node.left, target) || find(node.right, target);
        }

    }

    /**
     * 利用二叉树左右节点奇偶性进行logn跳转
     * 提升find时间效率
     */
    static class FindElements2 {

        TreeNode root;

        public FindElements2(TreeNode root) {
            this.root = root;
        }

        public boolean find(int target) {
            if (target < 0) return false;

            // 根据左右子节点奇偶性，构建查询路径（下一步向左还是向右跳）
            // true表示当前节点为父节点的右节点（child=2*parent+2），反之亦然
            Deque<Boolean> stk = new LinkedList<>();
            // target数字逐步除以二，回到父节点的值
            while (target != 0) {
                boolean isEven = target % 2 == 0;
                stk.push(isEven);
                target = isEven ? (target - 2) / 2 : (target - 1) / 2;
            }

            TreeNode curr = root;
            while (!stk.isEmpty()) {
                if (curr == null) {
                    return false;
                }
                Boolean rightChild = stk.pop();
                curr = rightChild ? curr.right : curr.left;
            }
            // 当前节点非null，说明能找到，否则不能
            return curr != null;
        }
    }
}
