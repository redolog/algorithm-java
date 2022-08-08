package com.algorithm.dataStructure.queue.priorityQueue;

import java.util.*;

/**
 * 2349. Design a Number Container System
 * Design a number container system that can do the following:
 * <p>
 * Insert or Replace a number at the given index in the system.
 * Return the smallest index for the given number in the system.
 * Implement the NumberContainers class:
 * <p>
 * NumberContainers() Initializes the number container system.
 * void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
 * int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
 * [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
 * Output
 * [null, -1, null, null, null, null, 1, null, 2]
 * <p>
 * Explanation
 * NumberContainers nc = new NumberContainers();
 * nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
 * nc.change(2, 10); // Your container at index 2 will be filled with number 10.
 * nc.change(1, 10); // Your container at index 1 will be filled with number 10.
 * nc.change(3, 10); // Your container at index 3 will be filled with number 10.
 * nc.change(5, 10); // Your container at index 5 will be filled with number 10.
 * nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
 * nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
 * nc.find(10); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= index, number <= 109
 * At most 105 calls will be made in total to change and find.
 * <p>
 * https://leetcode.cn/problems/design-a-number-container-system/
 *
 * @author dragonsong  @date 2022/8/8
 */
public class DesignANumberContainerSystem {

    /**
     * 数据结构目标：
     * 1. 可根据idx，更新对应值
     * 2. 可根据值，找到最小idx
     * 3. 查询、更新要求复杂度低
     */
    static class NumberContainers {
        /**
         * 位置->值
         */
        Map<Integer, Integer> idx2Num;
        /**
         * 值->红黑树
         * 树按从小到大顺序存值对应位置
         */
        Map<Integer, SortedSet<Integer>> num2SortedSet;

        public NumberContainers() {
            idx2Num = new HashMap<>();
            num2SortedSet = new HashMap<>();
        }

        public void change(int idx, int num) {
            Integer val = idx2Num.get(idx);
            if (val != null) {
                // 移除旧值
                if (val.equals(idx)) {
                    return;
                }
                // O(logn)
                SortedSet<Integer> set = num2SortedSet.get(val);
                set.remove(idx);
            }
            // O(logn)
            // 插入新值
            num2SortedSet.computeIfAbsent(num, (k) -> new TreeSet<>(Comparator.naturalOrder()));
            SortedSet<Integer> set = num2SortedSet.get(num);
            set.add(idx);
            idx2Num.put(idx, num);
        }

        public int find(int num) {
            // O(1)
            SortedSet<Integer> set = num2SortedSet.get(num);
            if (set == null || set.isEmpty()) {
                return -1;
            }
            return set.first();
        }
    }

    static class NumberContainers2 {
        /**
         * 位置->值
         */
        Map<Integer, Integer> idx2Num;
        /**
         * 值->有序队列
         * 队列按从小到大顺序存值对应位置
         */
        Map<Integer, Queue<Integer>> num2Queue;

        public NumberContainers2() {
            idx2Num = new HashMap<>();
            num2Queue = new HashMap<>();
        }

        public void change(int idx, int num) {
            // O(logn)
            // 插入新值
            num2Queue.computeIfAbsent(num, k -> new PriorityQueue<>(Comparator.naturalOrder())).offer(idx);
            idx2Num.put(idx, num);
        }

        /**
         * 延迟删除，使用堆顶浮出最值元素的方式
         * 如果in-place即时删除，则需要一个一个查找
         */
        public int find(int num) {
            Queue<Integer> queue = num2Queue.get(num);
            if (queue == null || queue.isEmpty()) {
                return -1;
            }
            // O(n*logn)
            // 每个idx最多插入、删除一次，因为均摊复杂度为O(logn)
            // 堆顶idx对应num应该是当前请求的，否则说明是旧数据
            while (!queue.isEmpty() && idx2Num.get(queue.peek()) != num) {
                queue.poll();
            }
            return queue.isEmpty() ? -1 : queue.peek();
        }
    }
}