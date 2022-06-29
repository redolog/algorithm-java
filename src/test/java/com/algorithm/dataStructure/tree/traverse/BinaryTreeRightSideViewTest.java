package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class BinaryTreeRightSideViewTest {

    @Test
    public void rightSideView() {
        BinaryTreeRightSideView service = new BinaryTreeRightSideView();
        assertEquals(Arrays.asList(1, 3, 4), service.rightSideView(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, null, 5, null, 4})));
        assertEquals(Arrays.asList(1, 3), service.rightSideView(TreeNode.buildAnyWithArr(new Integer[]{1, null, 3})));
        assertEquals(Collections.emptyList(), service.rightSideView(TreeNode.buildAnyWithArr(new Integer[]{})));
    }

    @Test
    public void rightSideViewWithDfs() {
        BinaryTreeRightSideView service = new BinaryTreeRightSideView();
        assertEquals(Arrays.asList(1, 3, 4), service.rightSideViewWithDfs(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, null, 5, null, 4})));
        assertEquals(Arrays.asList(1, 3), service.rightSideViewWithDfs(TreeNode.buildAnyWithArr(new Integer[]{1, null, 3})));
        assertEquals(Collections.emptyList(), service.rightSideViewWithDfs(TreeNode.buildAnyWithArr(new Integer[]{})));
    }
}