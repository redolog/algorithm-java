package com.algorithm.dataStructure.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class ArrayStackTest {

    ArrayStack arrayStack;

    @Before
    public void setUp() throws Exception {
        arrayStack = new ArrayStack(2);
    }


    @Test
    public void push() {

    }

    @Test
    public void pop() {
        assertThrows(IllegalStateException.class, () -> arrayStack.pop());

        arrayStack.push("第一个元素");
        arrayStack.push("第二个元素");

        Assert.assertEquals("第二个元素",arrayStack.pop());
        Assert.assertEquals("第一个元素",arrayStack.pop());
    }
}