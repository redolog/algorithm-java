package com.algorithm.dataStructure.tree.cbt;

import com.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dragonsong  @date 2022/8/10
 */
public class CBTInserter2 {

    List<TreeNode> list;

    int idx;

    public CBTInserter2(TreeNode root) {
        list = new ArrayList<>();
        list.add(root);
        idx = 0;
        int i = 0;
        while (i < list.size()) {
            TreeNode curr = list.get(i);
            if (curr.left != null) {
                list.add(curr.left);
            }
            if (curr.right != null) {
                list.add(curr.right);
            }
            i++;
        }
    }


    // O(1)
    public int insert(int val) {
        // O(1)
        TreeNode parent = getInsertParent();

        while (true) {
            if (parent.left == null) {
                parent.left = new TreeNode(val);
                list.add(parent.left);
                break;
            }
            if (parent.right == null) {
                parent.right = new TreeNode(val);
                list.add(parent.right);
                break;
            }
        }
        return parent.val;
    }

    private TreeNode getInsertParent() {
        // O(1)
        while (true) {
            TreeNode curr = list.get(idx);
            if (curr.left == null || curr.right == null) {
                return curr;
            }
            idx++;
        }
    }

    public TreeNode get_root() {
        return list.get(0);
    }

}
