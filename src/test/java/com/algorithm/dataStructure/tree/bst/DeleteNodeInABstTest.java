package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeInABstTest {

    @Test
    public void deleteNode() {
        DeleteNodeInABst service = new DeleteNodeInABst();

        TreeNode rootBefore = TreeNode.buildAnyWithArr(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode rootAfter = TreeNode.buildAnyWithArr(new Integer[]{5, 4, 6, 2, null, null, 7});
        TreeNode actual1 = service.deleteNodeRecursion(rootBefore, 3);
        Assert.assertEquals(rootAfter, actual1);
        TreeNode actual2 = service.deleteNodeRecursion(rootBefore, 0);
        Assert.assertEquals(rootBefore, actual2);
        TreeNode emptyNode = TreeNode.buildAnyWithArr(new Integer[]{});
        Assert.assertEquals(emptyNode, service.deleteNodeRecursion(emptyNode, 0));
    }
}