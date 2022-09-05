package com.algorithm.dataStructure.tree;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class FindDuplicateSubtreesTest {

    @Test
    public void testFindDuplicateSubtrees() {
        FindDuplicateSubtrees service = new FindDuplicateSubtrees();
        assertTrue(CollectionUtils.equals(Arrays.asList(TreeNode.buildAny(2, 4), TreeNode.buildAny(4)), service.findDuplicateSubtrees(TreeNode.buildAny(1, 2, 3, 4, null, 2, 4, null, null, 4))));
        assertTrue(CollectionUtils.equals(Collections.singletonList(TreeNode.buildAny(1)), service.findDuplicateSubtrees(TreeNode.buildAny(2, 1, 1))));
        assertTrue(CollectionUtils.equals(Arrays.asList(TreeNode.buildAny(2, 3), TreeNode.buildAny(3)), service.findDuplicateSubtrees(TreeNode.buildAny(2, 2, 2, 3, null, 3, null))));
    }
}