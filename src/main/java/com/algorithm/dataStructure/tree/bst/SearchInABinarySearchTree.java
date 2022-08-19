package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;

/**
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/
 *
 * @author dragonsong  @date 2022/8/19
 */
public class SearchInABinarySearchTree {

    static class Recursion {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
        }
    }

    static class Traverse {
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode curr = root;
            while (curr != null) {
                if (curr.val == val) {
                    return curr;
                }
                curr = curr.val < val ? curr.right : curr.left;
            }
            return null;
        }
    }
}
