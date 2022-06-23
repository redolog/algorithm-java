package com.algorithm.dataStructure.array.app;

import java.util.Arrays;
import java.util.Objects;

/**
 * 基于数组的LRU
 *
 * @author dragonsong  @date 2022/6/23
 */
public class ArrayLRU<K, V> {

    /**
     * 数组装数据
     */
    Entry<K, V>[] elements;
    /**
     * 队头：恒指向0
     */
    int head;
    /**
     * 队尾：指向待插入的下标
     */
    int tail;
    /**
     * 容量
     */
    int capacity;

    @SuppressWarnings("unchecked")
    public ArrayLRU(int capacity) {
        this.capacity = capacity;
        this.head = tail = 0;
        elements = new Entry[capacity];
    }

    /**
     * 根据key访问元素：
     * - 无元素时，返回null
     * - 有元素时，返回对应entry
     *
     * @param key 查询key
     * @return Entry
     */
    public Entry<K, V> get(K key) {
        if (head == tail) {
            return null;
        }
        for (int i = head; i < tail; i++) {
            Entry<K, V> target = elements[i];
            if (target.key.equals(key)) {
                // 搬移 i到0队头的位置
                for (int j = i; j > 0; j--) {
                    elements[j] = elements[j - 1];
                }
                elements[0] = target;
                return target;
            }
        }
        return null;
    }

    public void put(K key, V val) {
        int targetIdx = findIdxByKey(key);

        if (targetIdx >= head && targetIdx < tail) {
            // 元素已存在数组中 搬移
            Entry<K, V> targetEntry = elements[targetIdx];
            targetEntry.val = val;
            for (int i = targetIdx; i > 0; i--) {
                elements[i] = elements[i - 1];
            }
            elements[head] = targetEntry;
        } else {
            if (tail > capacity - 1) {
                // 淘汰队尾
                elements[tail - 1] = null;
                --tail;
            }
            ++tail;
            for (int i = tail - 1; i > 0; i--) {
                elements[i] = elements[i - 1];
            }
            elements[head] = new Entry<>(key, val);
        }
    }

    private int findIdxByKey(K key) {
        for (int i = 0; i < tail; i++) {
            if (elements[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println(this);
        Arrays.stream(elements).filter(Objects::nonNull).forEach(element -> {
            System.out.print(element.key + "->" + element.val + "》》");
        });
        System.out.println();
    }

    @Override
    public String toString() {
        return "ArrayLRU{" + "head=" + head + ", tail=" + tail + ", capacity=" + capacity + '}';
    }

    static class Entry<K, V> {
        K key;
        V val;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
