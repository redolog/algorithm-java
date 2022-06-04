package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BTreeZigZagLevelOrderTest {
    BTreeZigZagLevelOrder service;

    @Before
    public void before() {
        service = new BTreeZigZagLevelOrder();
    }

    @Test
    public void testZigzagLevelOrder() {
        List<List<Integer>> lists = service.zigzagLevelOrder(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7}));

        assertEquals("[[3],[20,9],[15,7]]", lists.toString().replace(" ", ""));
//
        assertEquals("[[1],[3,2],[4,5]]", service.zigzagLevelOrder(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, null, null, 5})).toString().replace(" ", ""));
        assertEquals("[[1],[3,2],[4,5]]", service.zigzagLevelOrder(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5})).toString().replace(" ", ""));
//        TreeNode root = TreeNode.buildWithArr(new int[]{1, 2, null, 3, null, 4, null, 5});
//        assertEquals("[[1],[2],[3],[4],[5]]",service.zigzagLevelOrder(root).toString().replace(" ",""));
    }
}