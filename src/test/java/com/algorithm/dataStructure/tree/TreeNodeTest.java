package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static com.algorithm.dataStructure.tree.TreeNode.INVALID_VAL;

public class TreeNodeTest {

    @Test
    public void buildWithArr() {
        TreeNode treeNode = TreeNode.buildCompleteWithArr(new int[]{3, 9, 20, INVALID_VAL, INVALID_VAL, 15, 7});
        System.out.println(treeNode);
    }
}