package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsufficientNodesInRootToLeafPathsTest {

    @Test
    public void sufficientSubset() {
        InsufficientNodesInRootToLeafPaths service = new InsufficientNodesInRootToLeafPaths();
        TreeNode ans1 = service.sufficientSubset(TreeNode.buildAny(1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12, 13, -99, 14), 1);
        TreeNode.print(ans1);
        assertEquals(
                TreeNode.buildAny(1, 2, 3, 4, null, null, 7, 8, 9, null, 14),
                ans1
        );
        TreeNode ans2 = service.sufficientSubset(TreeNode.buildAny(1,2,-3,-5,null,4,null), -1);
        TreeNode.print(ans2);
        assertEquals(
                TreeNode.buildAny(1, null, -3, 4),
                ans2
        );
    }
}