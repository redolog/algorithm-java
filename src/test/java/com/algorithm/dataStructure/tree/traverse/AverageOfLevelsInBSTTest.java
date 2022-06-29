package com.algorithm.dataStructure.tree.traverse;

import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AverageOfLevelsInBSTTest {

    @Test
    public void averageOfLevels() {
        AverageOfLevelsInBST service = new AverageOfLevelsInBST();
        assertEquals(Arrays.asList(3.00000, 14.50000, 11.00000), service.averageOfLevels(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertEquals(Arrays.asList(3.00000, 14.50000, 11.00000), service.averageOfLevels(TreeNode.buildAnyWithArr(new Integer[]{3, 9, 20, 15, 7})));
        assertEquals(Arrays.asList(2147483647.0, 2147483647.0), service.averageOfLevels(TreeNode.buildAnyWithArr(new Integer[]{2147483647, 2147483647, 2147483647})));
    }
}