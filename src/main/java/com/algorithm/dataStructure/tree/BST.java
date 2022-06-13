package com.algorithm.dataStructure.tree;

/**
 * 二叉搜索树
 * BinarySearchTree
 *
 * @author dragonsong  @date 2022/5/31
 */
public class BST {

    public TreeNode root;

    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(TreeNode curr, int val) {
        if (curr == null) {
            return false;
        }
        if (curr.val == val) {
            return true;
        }

        if (curr.val > val) {
            return contains(curr.left, val);
        } else {
            return contains(curr.right, val);
        }
    }

    /**
     * 传入一棵BST树，返回其最小值节点
     */
    public TreeNode miniNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 遍历到无左子节点的节点时，为最小节点
        if (node.left == null) {
            return node;
        }
        return miniNode(node.left);
    }

    /**
     * 传入一棵BST树，返回其最大值节点
     */
    public TreeNode maxNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 遍历到无右子节点的节点时，为最大节点
        if (node.right == null) {
            return node;
        }
        return maxNode(node.right);
    }

    /**
     * 删除BST下最小节点，返回树根
     *
     * @param node 当前树根节点
     * @return 返回删除最小节点后的树根
     */
    public TreeNode removeMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 当前节点如果没有左子节点，说明有已经是最小
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除BST下最大节点，返回树根
     *
     * @param node 当前树根节点
     * @return 返回删除最大节点后的树根
     */
    public TreeNode removeMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        // 当前节点如果没有右子节点，说明有已经是最大
        if (node.right == null) {
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

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
        delete(root, val);
    }

    /**
     * @return 返回删除完val节点后的子树根节点
     */
    private TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val > val) {
            node.left = delete(node.left, val);
            return node;
        } else if (node.val < val) {
            node.right = delete(node.right, val);
            return node;
        } else {
            // node.val==val
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // val等值节点同时有左右子节点，删除右子树下的最小节点，同时将右子树最小节点替换到node的位置
            TreeNode rightMini = miniNode(node.right);
            rightMini.right = removeMin(node.right);
            rightMini.left = node.left;
            return rightMini;
        }
    }

}
