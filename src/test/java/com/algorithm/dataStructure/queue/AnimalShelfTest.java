package com.algorithm.dataStructure.queue;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class AnimalShelfTest {

    @Test
    public void testAnimalShelf() {
        AnimalShelf animalShelf = new AnimalShelf();
        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});
        assertArrayEquals(new int[]{0, 0}, animalShelf.dequeueCat());
        assertArrayEquals(new int[]{-1, -1}, animalShelf.dequeueDog());
        assertArrayEquals(new int[]{1, 0}, animalShelf.dequeueAny());

        /*
         *  输入：
         * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
         * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
         *  输出：
         * [null,null,null,null,[2,1],[0,0],[1,0]]
         */
        animalShelf.clear();
        animalShelf.enqueue(new int[]{0, 0});
        animalShelf.enqueue(new int[]{1, 0});
        animalShelf.enqueue(new int[]{2, 1});
        assertArrayEquals(new int[]{2, 1}, animalShelf.dequeueDog());
        assertArrayEquals(new int[]{0, 0}, animalShelf.dequeueCat());
        assertArrayEquals(new int[]{1, 0}, animalShelf.dequeueAny());

    }
}