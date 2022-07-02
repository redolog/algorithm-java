package com.algorithm.dataStructure.tree.serialize;

import com.algorithm.dataStructure.tree.IsSameTree;
import com.algorithm.dataStructure.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SerializeAndDeserializeBinaryTreeTest {
    SerializeAndDeserializeBinaryTree service = new SerializeAndDeserializeBinaryTree();

    @Test
    public void testSerialize() {
        TreeNode originalTree = TreeNode.buildAnyWithArr(new Integer[]{1, 2, 3, null, null, 4, 5});
        String str = service.serialize(originalTree);
        System.out.println(str);

        TreeNode deserializedTree = service.deserialize(str);
        System.out.println(deserializedTree);

        IsSameTree isSameTree = new IsSameTree();
        assertTrue(isSameTree.isSameTree(originalTree, deserializedTree));
    }
}