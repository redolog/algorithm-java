package com.algorithm.dataStructure.linkedList;

import org.junit.Test;

public class PrintImmutableLinkedListInReverseTest {

    @Test
    public void testPrintImmutableLinkedListInReverse() {
        PrintImmutableLinkedListInReverse.ConstantSpaceComplexityWithLen constantSpaceComplexityWithLen = new PrintImmutableLinkedListInReverse.ConstantSpaceComplexityWithLen();
        constantSpaceComplexityWithLen.printLinkedListInReverse(ListNode.build(1, 2, 3, 4));

        PrintImmutableLinkedListInReverse.DC dc = new PrintImmutableLinkedListInReverse.DC();
        dc.printLinkedListInReverse(ListNode.build(1, 2, 3, 4));
    }

}