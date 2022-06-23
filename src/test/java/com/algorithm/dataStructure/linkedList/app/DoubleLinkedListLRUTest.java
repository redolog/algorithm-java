package com.algorithm.dataStructure.linkedList.app;

import org.junit.Test;

import java.util.Scanner;

public class DoubleLinkedListLRUTest {

    public static void main(String[] args) {
        DoubleLinkedListLRU<Integer, Integer> lru = new DoubleLinkedListLRU<>(10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            lru.put(i, i);
            lru.print();

            DoubleLinkedListLRU.DoubleLinkedListNode<Integer, Integer> randomNode = lru.randomNode();
            Integer key = randomNode.entry.key;
            System.out.println("randomKey-->" + key);
            lru.get(key);
            lru.print();
        }
    }

    @Test
    public void testDoubleLinkedListLRU() {

    }
}