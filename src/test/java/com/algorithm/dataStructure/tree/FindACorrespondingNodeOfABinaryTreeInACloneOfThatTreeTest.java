package com.algorithm.dataStructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTreeTest {

    @Test
    public void getTargetCopy() {
        FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree service = new FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree();
        assertEquals(3, service.getTargetCopy(TreeNode.buildAny(7, 4, 3, null, null, 6, 19), TreeNode.buildAny(3)).val);
        assertEquals(7, service.getTargetCopy(TreeNode.buildAny(7), TreeNode.buildAny(7)).val);
        assertEquals(4, service.getTargetCopy(TreeNode.buildAny(8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1), TreeNode.buildAny(4)).val);
    }
}