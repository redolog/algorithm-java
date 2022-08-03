package com.algorithm.dataStructure.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题 03.06. 动物收容所
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 * <p>
 * 收纳所的最大容量为20000
 * <p>
 * https://leetcode.cn/problems/animal-shelter-lcci/
 *
 * @author dragonsong  @date 2022/8/3
 */
public class AnimalShelf {

    // 总的队列，维护猫狗顺序，猫0false，狗1true
    Deque<Boolean> totalQ;

    Queue<Integer> dogQ;
    Queue<Integer> catQ;

    public AnimalShelf() {
        totalQ = new LinkedList<>();
        dogQ = new LinkedList<>();
        catQ = new LinkedList<>();
    }

    public void clear() {
        totalQ = new LinkedList<>();
        dogQ = new LinkedList<>();
        catQ = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        int num = animal[0];
        int type = animal[1];

        if (type == 0) {
            totalQ.offer(false);
            catQ.offer(num);
        } else {
            totalQ.offer(true);
            dogQ.offer(num);
        }
    }

    public int[] dequeueAny() {
        if (totalQ.isEmpty()) {
            return new int[]{-1, -1};
        }
        boolean isDog = totalQ.poll();
        int[] animal = new int[2];
        animal[0] = isDog ? dogQ.poll() : catQ.poll();
        animal[1] = isDog ? 1 : 0;
        return animal;
    }

    public int[] dequeueDog() {
        if (dogQ.isEmpty()) {
            return new int[]{-1, -1};
        }
        dequeueFromTotal(true);

        int[] animal = new int[2];
        animal[0] = dogQ.poll();
        animal[1] = 1;
        return animal;
    }

    private void dequeueFromTotal(boolean dog) {
        Deque<Boolean> stack = new ArrayDeque<>();
        while (dog != totalQ.peek()) {
            stack.push(totalQ.poll());
        }
        totalQ.poll();
        while (!stack.isEmpty()) {
            totalQ.offerFirst(stack.pop());
        }
    }

    public int[] dequeueCat() {
        if (catQ.isEmpty()) {
            return new int[]{-1, -1};
        }
        dequeueFromTotal(false);

        int[] animal = new int[2];
        animal[0] = catQ.poll();
        animal[1] = 0;
        return animal;
    }
}
