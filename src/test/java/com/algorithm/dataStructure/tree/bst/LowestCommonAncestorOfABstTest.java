package com.algorithm.dataStructure.tree.bst;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorOfABstTest {

    @Test
    public void lowestCommonAncestor() {
        LowestCommonAncestorOfABst service = new LowestCommonAncestorOfABst();

        TreeNode reqNode = TreeNode.buildAnyWithArr(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode ans1 = service.lowestCommonAncestor(reqNode,
                TreeNode.buildAnyWithArr(new Integer[]{2}), TreeNode.buildAnyWithArr(new Integer[]{8}));
        assertEquals(6, ans1.val);
        TreeNode ans2 = service.lowestCommonAncestor(reqNode,
                TreeNode.buildAnyWithArr(new Integer[]{2}), TreeNode.buildAnyWithArr(new Integer[]{4}));
        assertEquals(2, ans2.val);

    }
}