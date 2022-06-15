package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

public class BTreeInOrderTest {

    @Test
    public void inOrderStack() {
        BTreeInOrder.inOrderStack(TreeNode.buildAnyWithArr(new Integer[]{2, 1, 3}));

    }
}