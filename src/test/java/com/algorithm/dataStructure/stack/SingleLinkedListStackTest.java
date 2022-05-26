package com.algorithm.dataStructure.stack;

import com.algorithm.probability.EP;
import com.algorithm.util.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThrows;

public class SingleLinkedListStackTest {

    @Test
    public void push() {
        SingleLinkedListStack stack = new SingleLinkedListStack(2);

        assertThrows(NoSuchElementException.class, stack::pop);

        stack.push(1);
        stack.push(2);

        Assert.assertEquals(2,stack.pop());
        Assert.assertEquals(1,stack.pop());

        int opTimes = 10000;
        int maxVal = 1000;

        SingleLinkedListStack singleLinkedListStack = new SingleLinkedListStack(opTimes);
        LinkedList<Integer> linkedListStack = new LinkedList<>();

        for (int i = 0; i < opTimes; i++) {
            // 测试testTimes次数

            switch (EP.rand13()) {
                case 1:
                    // 增
                    int randomInt = NumberUtils.randomInt(maxVal);
                    Assert.assertEquals(linkedListStack.offerFirst(randomInt), singleLinkedListStack.push(randomInt));
                    break;
                case 2:
                    // 删
                    try {
                        Integer jdkEle = linkedListStack.pop();
                        int myEle = singleLinkedListStack.pop();
                        Assert.assertEquals(jdkEle, Integer.valueOf(myEle));
                    } catch (NoSuchElementException e) {
                        Assert.assertThrows(NoSuchElementException.class, linkedListStack::pop);
                        Assert.assertThrows(NoSuchElementException.class, singleLinkedListStack::pop);
                    }
                    break;
                case 3:
                    // 查
                    int myEle = singleLinkedListStack.peek();
                    Integer jdkEle = linkedListStack.peek();
                    System.out.println("peek::myEle::" + myEle + "  jdkEle::" + jdkEle);
                    break;
            }
        }
    }
}