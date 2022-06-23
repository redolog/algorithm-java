package com.algorithm.dataStructure.linkedList.app;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class LinkedListLRUTest {

    public static void main(String[] args) {
        LinkedListLRU<Integer> lru = new LinkedListLRU<>(10);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int val = scanner.nextInt();
            lru.put(val);

            Assert.assertEquals(val, (int) lru.dummy.next.val);

            Assert.assertTrue(lru.size <= lru.capacity);
            lru.print();
        }
    }

    /**
     * 1
     * LinkedListLRU{capacity=10, size=1}
     * 1-->
     * 2
     * LinkedListLRU{capacity=10, size=2}
     * 2-->1-->
     * 1
     * LinkedListLRU{capacity=10, size=2}
     * 1-->2-->
     * 3
     * LinkedListLRU{capacity=10, size=3}
     * 3-->1-->2-->
     * 4
     * LinkedListLRU{capacity=10, size=4}
     * 4-->3-->1-->2-->
     * 4
     * LinkedListLRU{capacity=10, size=4}
     * 4-->3-->1-->2-->
     * 4
     * LinkedListLRU{capacity=10, size=4}
     * 4-->3-->1-->2-->
     * 5
     * LinkedListLRU{capacity=10, size=5}
     * 5-->4-->3-->1-->2-->
     * 6
     * LinkedListLRU{capacity=10, size=6}
     * 6-->5-->4-->3-->1-->2-->
     * 7
     * LinkedListLRU{capacity=10, size=7}
     * 7-->6-->5-->4-->3-->1-->2-->
     * 78
     * LinkedListLRU{capacity=10, size=8}
     * 78-->7-->6-->5-->4-->3-->1-->2-->
     * 8
     * LinkedListLRU{capacity=10, size=9}
     * 8-->78-->7-->6-->5-->4-->3-->1-->2-->
     * 9
     * LinkedListLRU{capacity=10, size=10}
     * 9-->8-->78-->7-->6-->5-->4-->3-->1-->2-->
     * 10
     * LinkedListLRU{capacity=10, size=10}
     * 10-->9-->8-->78-->7-->6-->5-->4-->3-->1-->
     */
    @Test
    public void testLinkedListLRU() {

    }
}