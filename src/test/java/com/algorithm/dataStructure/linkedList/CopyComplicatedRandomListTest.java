package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

public class CopyComplicatedRandomListTest {

    @Test
    public void copyRandomListWithShadowNode() {
        CopyComplicatedRandomList service = new CopyComplicatedRandomList();
        Integer[][] vals = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        CopyComplicatedRandomList.Node head = CopyComplicatedRandomList.Node.build(vals);
        CopyComplicatedRandomList.Node newHead = service.copyRandomListWithShadowNode(head);
        System.out.println(newHead);

    }
}