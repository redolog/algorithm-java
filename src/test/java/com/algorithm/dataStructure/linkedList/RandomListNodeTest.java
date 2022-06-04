package com.algorithm.dataStructure.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class RandomListNodeTest {

    @Test
    public void buildTest() {
        Integer[][] vals = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};

        RandomListNode curr = RandomListNode.build(vals);
        int idx = 0;
        while (curr != null) {
            Integer[] valPair = vals[idx];
            Integer nodeVal = valPair[0];
            Integer randomIdx = valPair[1];
            Assert.assertEquals((int) nodeVal, curr.val);

            if(curr.random==null){
                Assert.assertNull(randomIdx);
            }else{
                Assert.assertEquals(curr.random.val,(int)vals[randomIdx][0]);
            }
            ++idx;
            curr = curr.next;
        }
    }
}