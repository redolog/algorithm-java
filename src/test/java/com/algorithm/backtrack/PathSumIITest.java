package com.algorithm.backtrack;

import com.algorithm.dataStructure.tree.TreeNode;
import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PathSumIITest {

    @Test
    public void pathSum() {
        PathSumII backtrack = new PathSumII();
        List<List<Integer>> ansList1 = backtrack.pathSum(TreeNode.buildAnyWithArr(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        List<List<?>> ansListExpect1 = new ArrayList<>(Arrays.asList(Arrays.asList(5, 4, 11, 2), Arrays.asList(5, 8, 4, 5)));
        assertTrue(CollectionUtils.equals(ansList1, ansListExpect1));
        List<List<Integer>> ansList2 = backtrack.pathSum(TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3}), 5);
        assertTrue(CollectionUtils.equals(ansList2, Collections.emptyList()));
        List<List<Integer>> ansList3 = backtrack.pathSum(TreeNode.buildAnyWithArr(new Integer[]{1, 2}), 0);
        assertTrue(CollectionUtils.equals(ansList3, Collections.emptyList()));

    }
}