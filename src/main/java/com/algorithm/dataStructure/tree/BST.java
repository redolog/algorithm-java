package com.algorithm.dataStructure.tree;

/**
 * 二叉搜索树
 * BinarySearchTree
 *
 * @author dragonsong  @date 2022/5/31
 */
public class BST {

    public TreeNode root;

    /**
     * 查 val 对应BST上的节点
     * 1. 从当前节点出发，val如果等于当前节点值，直接返回节点
     * 2. 如果不相等，判断节点值大于val的话，遍历左子树，否则遍历右子树
     *
     * @param val 待查找的值
     * @return 查找的节点，未找到返回null
     */
    public TreeNode query(int val) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == val) {
                return curr;
            }
            curr = curr.val > val ? curr.left : curr.right;
        }
        return null;
    }

    /**
     * 插入 val 值节点。
     * 判断val与当前节点的关系：
     * 1. 当前节点大于val，检查左子树，如果不存在，直接创建左子树节点，如果存在，继续判断大小关系
     * 2. 当前节点小于val，检查右子树，如果不存在，直接创建右子树节点，如果存在，继续判断大小关系
     *
     * @param val 待插入int值
     */
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode curr = root;
        while (true) {
            if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }
    }

    /**
     * 删除节点：
     * 1. 节点无子树，直接将父节点的子设置为null
     * 2. 节点有一个子树，将右子树中的最小值置于此处，右子树的最小值一定没有左子节点
     * 3. 节点有两个子节点，将右子树中的最小值置于此处，同时删除该最小值原节点
     *
     * @param val 待删除值
     */
    public void delete(int val) {
    }

}
