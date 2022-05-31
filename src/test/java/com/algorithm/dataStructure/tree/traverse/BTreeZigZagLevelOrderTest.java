package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.algorithm.dataStructure.tree.TreeNode.INVALID_VAL;
import static org.junit.Assert.assertEquals;

public class BTreeZigZagLevelOrderTest {
    BTreeZigZagLevelOrder service;

    @Before
    public void before() {
        service = new BTreeZigZagLevelOrder();
    }

    @Test
    public void testZigzagLevelOrder() {
        List<List<Integer>> lists = service.zigzagLevelOrder(TreeNode.buildWithArr(new int[]{3, 9, 20, INVALID_VAL, INVALID_VAL, 15, 7}));

        assertEquals("[[3],[20,9],[15,7]]", lists.toString().replace(" ", ""));
//
        assertEquals("[[1],[3,2],[4,5]]",service.zigzagLevelOrder(TreeNode.buildWithArr(new int[]{1,2,3,4,INVALID_VAL,INVALID_VAL,5})).toString().replace(" ",""));
        assertEquals("[[1],[3,2],[4,5]]",service.zigzagLevelOrder(TreeNode.buildWithArr(new int[]{1,2,3,4,5})).toString().replace(" ",""));
//        TreeNode root = TreeNode.buildWithArr(new int[]{1, 2, INVALID_VAL, 3, INVALID_VAL, 4, INVALID_VAL, 5});
//        assertEquals("[[1],[2],[3],[4],[5]]",service.zigzagLevelOrder(root).toString().replace(" ",""));
    }
}