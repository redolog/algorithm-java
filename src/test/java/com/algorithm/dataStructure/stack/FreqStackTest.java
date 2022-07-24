package com.algorithm.dataStructure.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreqStackTest {

    @Test
    public void push() {
        FreqStack freqStack = new FreqStack();

        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        assertEquals(5, freqStack.pop());
        assertEquals(7, freqStack.pop());
        assertEquals(5, freqStack.pop());
        assertEquals(4, freqStack.pop());

        System.out.println(freqStack);
    }
}