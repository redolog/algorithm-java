package com.algorithm.dataStructure.tree.cbt;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CBTInserterTest {

    @Test
    public void testCBTInserter() {
        CBTInserter cbtInserter = new CBTInserter(TreeNode.buildAnyWithArr(new Integer[]{1, 2}));
        assertFalse(cbtInserter.isLastLevelFull(cbtInserter.cnt));
        assertEquals(1, cbtInserter.insert(3));  // 返回 1
        assertEquals(2, cbtInserter.insert(4));  // 返回 2
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4}), cbtInserter.get_root()); // 返回 [1, 2, 3, 4]

        CBTInserter cbtInserter2 = new CBTInserter(TreeNode.buildAnyWithArr(new Integer[]{1}));
        assertTrue(cbtInserter2.isLastLevelFull(cbtInserter2.cnt));
        assertEquals(1, cbtInserter2.insert(2));
        assertEquals(1, cbtInserter2.insert(3));
        assertEquals(2, cbtInserter2.insert(4));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4}), cbtInserter2.get_root());

        CBTInserter cbtInserter3 = new CBTInserter(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, cbtInserter3.insert(7));
        assertEquals(4, cbtInserter3.insert(8));

        // 2

        CBTInserter2 cbtInserter21 = new CBTInserter2(TreeNode.buildAnyWithArr(new Integer[]{1, 2}));
        assertEquals(1, cbtInserter21.insert(3));  // 返回 1
        assertEquals(2, cbtInserter21.insert(4));  // 返回 2
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4}), cbtInserter21.get_root()); // 返回 [1, 2, 3, 4]

        CBTInserter2 cbtInserter22 = new CBTInserter2(TreeNode.buildAnyWithArr(new Integer[]{1}));
        assertEquals(1, cbtInserter22.insert(2));
        assertEquals(1, cbtInserter22.insert(3));
        assertEquals(2, cbtInserter22.insert(4));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4}), cbtInserter22.get_root());

        CBTInserter2 cbtInserter23 = new CBTInserter2(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, cbtInserter23.insert(7));
        assertEquals(4, cbtInserter23.insert(8));

        // 3

        CBTInserter3 cbtInserter31 = new CBTInserter3(TreeNode.buildAnyWithArr(new Integer[]{1, 2}));
        assertEquals(1, cbtInserter31.insert(3));  // 返回 1
        assertEquals(2, cbtInserter31.insert(4));  // 返回 2
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4}), cbtInserter31.get_root()); // 返回 [1, 2, 3, 4]

        CBTInserter3 cbtInserter32 = new CBTInserter3(TreeNode.buildAnyWithArr(new Integer[]{1}));
        assertEquals(1, cbtInserter32.insert(2));
        assertEquals(1, cbtInserter32.insert(3));
        assertEquals(2, cbtInserter32.insert(4));
        assertEquals(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4}), cbtInserter32.get_root());

        CBTInserter3 cbtInserter33 = new CBTInserter3(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, cbtInserter33.insert(7));
        assertEquals(4, cbtInserter33.insert(8));
    }
}