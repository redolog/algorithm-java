package com.algorithm.dataStructure.stack;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {

    @Test
    public void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());

        minStack.clear();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.getMin());

    }

    @Test
    public void testMinStack2() {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());

        minStack.clear();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.getMin());

    }

    @Test
    public void testMinStack3() {
        MinStack3 minStack = new MinStack3();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());

        minStack.clear();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.getMin());

    }
}