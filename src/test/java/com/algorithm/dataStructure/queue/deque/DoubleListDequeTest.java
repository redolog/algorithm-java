package com.algorithm.dataStructure.queue.deque;

import com.algorithm.probability.EP;
import com.algorithm.util.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class DoubleListDequeTest {

    @Test
    public void testDoubleListDeque() {

        int opTimes = 10000;
        int maxVal = 1000;

        DoubleListDeque doubleListDeque = new DoubleListDeque();
        Deque<Integer> linkedListDeque = new LinkedList<>();

        for (int i = 0; i < opTimes; i++) {
            // 测试testTimes次数

            switch (EP.rand13()) {
                case 1:
                    // 增
                    int randomInt = NumberUtils.randomInt(maxVal);
                    if (Math.random() < 0.5) {
                        doubleListDeque.enqueueHead(randomInt);
                        linkedListDeque.addFirst(randomInt);
                    } else {
                        doubleListDeque.enqueueTail(randomInt);
                        linkedListDeque.addLast(randomInt);
                    }
                    break;
                case 2:
                    // 删
                    if (!doubleListDeque.isEmpty()) {
                        int int1, int2;
                        if (Math.random() < 0.5) {
                            int1 = doubleListDeque.dequeueHead();
                            int2 = linkedListDeque.pollFirst();
                        } else {
                            int1 = doubleListDeque.dequeueTail();
                            int2 = linkedListDeque.pollLast();
                        }

                        Assert.assertEquals(int1, int2);
                    }
                    break;
                case 3:
                    // 查
                    if (!doubleListDeque.isEmpty()) {
                        int int1, int2;
                        if (Math.random() < 0.5) {
                            int1 = doubleListDeque.peekHead();
                            int2 = linkedListDeque.peekFirst();
                        } else {
                            int1 = doubleListDeque.peekTail();
                            int2 = linkedListDeque.peekLast();
                        }
                        Assert.assertEquals(int1, int2);
                    } else {
                        Assert.assertEquals(-1, doubleListDeque.peekHead());
                        Assert.assertNull(linkedListDeque.peekFirst());
                    }

                    break;
            }
        }
    }
}