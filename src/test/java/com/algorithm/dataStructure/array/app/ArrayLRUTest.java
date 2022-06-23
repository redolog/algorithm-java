package com.algorithm.dataStructure.array.app;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ArrayLRUTest {

    public static void main(String[] args) {
        ArrayLRU<Integer, Integer> lru = new ArrayLRU<>(10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int nextInt = scanner.nextInt();
            lru.put(nextInt, nextInt);
            Assert.assertEquals(nextInt, (int) lru.elements[lru.head].key);
            Assert.assertTrue(lru.tail <= lru.capacity);
            lru.print();
        }
    }

    /**
     * 1
     * ArrayLRU{head=0, tail=1, capacity=10}
     * 1->1》》
     * 1
     * ArrayLRU{head=0, tail=1, capacity=10}
     * 1->1》》
     * 2
     * ArrayLRU{head=0, tail=2, capacity=10}
     * 2->2》》1->1》》
     * 3
     * ArrayLRU{head=0, tail=3, capacity=10}
     * 3->3》》2->2》》1->1》》
     * 4
     * ArrayLRU{head=0, tail=4, capacity=10}
     * 4->4》》3->3》》2->2》》1->1》》
     * 5
     * ArrayLRU{head=0, tail=5, capacity=10}
     * 5->5》》4->4》》3->3》》2->2》》1->1》》
     * 6
     * ArrayLRU{head=0, tail=6, capacity=10}
     * 6->6》》5->5》》4->4》》3->3》》2->2》》1->1》》
     * 7
     * ArrayLRU{head=0, tail=7, capacity=10}
     * 7->7》》6->6》》5->5》》4->4》》3->3》》2->2》》1->1》》
     * 8
     * ArrayLRU{head=0, tail=8, capacity=10}
     * 8->8》》7->7》》6->6》》5->5》》4->4》》3->3》》2->2》》1->1》》
     * 9
     * ArrayLRU{head=0, tail=9, capacity=10}
     * 9->9》》8->8》》7->7》》6->6》》5->5》》4->4》》3->3》》2->2》》1->1》》
     * 10
     * ArrayLRU{head=0, tail=10, capacity=10}
     * 10->10》》9->9》》8->8》》7->7》》6->6》》5->5》》4->4》》3->3》》2->2》》1->1》》
     * 11
     * ArrayLRU{head=0, tail=10, capacity=10}
     * 11->11》》10->10》》9->9》》8->8》》7->7》》6->6》》5->5》》4->4》》3->3》》2->2》》
     * 2
     * ArrayLRU{head=0, tail=10, capacity=10}
     * 2->2》》11->11》》10->10》》9->9》》8->8》》7->7》》6->6》》5->5》》4->4》》3->3》》
     */
    @Test
    public void testArrayLRU() {

    }
}