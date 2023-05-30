package com.algorithm.dataStructure.tree;

import org.junit.Test;

import java.util.List;

public class DeleteNodesAndReturnForestTest {

    @Test
    public void delNodes() {
        DeleteNodesAndReturnForest service = new DeleteNodesAndReturnForest();
//        List<TreeNode> ans1 = service.delNodes(TreeNode.buildAny(1, 2, 3, 4, 5, 6, 7), new int[]{3, 5});
//        System.out.println(ans1);
//        List<TreeNode> ans2 = service.delNodes(TreeNode.buildAny(1, 2, 4, null, 3), new int[]{3});
//        System.out.println(ans2);
        List<TreeNode> ans3 = service.delNodes(TreeNode.buildAny(1, 3, 2, null, 6, 4, null, null, null, 5), new int[]{2, 5, 3});
        System.out.println(ans3);
    }
}