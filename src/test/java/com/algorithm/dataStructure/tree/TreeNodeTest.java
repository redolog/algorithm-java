package com.algorithm.dataStructure.tree;

import org.junit.Test;


public class TreeNodeTest {

    @Test
    public void buildWithArr() {
        TreeNode treeNode = TreeNode.buildCompleteWithArr(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(treeNode);
    }
}