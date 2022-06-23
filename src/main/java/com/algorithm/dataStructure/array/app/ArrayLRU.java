package com.algorithm.dataStructure.array.app;

import com.algorithm.util.MapUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    /**
     * key——》数组下标，方便访问，降低查坐标复杂度
     */
    Map<K, Integer> k2Idx;

    @SuppressWarnings("unchecked")
    public ArrayLRU(int capacity) {
        this.capacity = capacity;
        this.head = tail = 0;
        elements = new Entry[capacity];
        k2Idx = new HashMap<>(MapUtils.capacity(capacity));
    }

    /**
     * 根据key访问元素：
     * - 无元素时，返回null
     * - 有元素时，返回对应entry
     * <p>
     * 复杂度：
     * 每次均遍历整个数组，并且需要搬移前序数据，时间复杂度 O(n)
     * <p>
     * 优化：
     * 使用map缓存 key->index，降低查找元素位置的复杂度为 O(1)
     *
     * @param key 查询key
     * @return Entry
     */
    public Entry<K, V> get(K key) {
        if (head == tail) {
            return null;
        }
        Integer idx = k2Idx.get(key);
        if (null == idx || idx < head || idx >= tail) {
            return null;
        }
        Entry<K, V> target = elements[idx];
        // 搬移 i到0队头的位置
        moveArrFromEndInclusive(idx, target);
        return target;
//        for (int i = head; i < tail; i++) {
//            Entry<K, V> target = elements[i];
//            if (target.key.equals(key)) {
//                // 搬移 i到0队头的位置
//                moveArrFromEndInclusive(i, target);
//                return target;
//            }
//        }
//        return null;
    }

    /**
     * 从 i往1 的闭区间右移元素
     */
    private void moveArrFromEndInclusive(int i, Entry<K, V> target) {
        for (int j = i; j > 0; j--) {
            elements[j] = elements[j - 1];
            k2Idx.put(elements[j].key, j);
        }
        elements[head] = target;
        k2Idx.put(target.key, head);
    }

    /**
     * 复杂度：
     * 每次均需遍历数组、搬移数据，时间复杂度 O(n)
     */
    public void put(K key, V val) {
        int targetIdx = findIdxByKey(key);

        if (targetIdx >= head && targetIdx < tail) {
            // 元素已存在数组中 搬移
            Entry<K, V> targetEntry = elements[targetIdx];
            targetEntry.val = val;
            moveArrFromEndInclusive(targetIdx, targetEntry);
        } else {
            if (tail > capacity - 1) {
                // 淘汰队尾
                elements[tail - 1] = null;
                --tail;
            }
            ++tail;
            moveArrFromEndInclusive(tail - 1, new Entry<>(key, val));
        }
    }

    private int findIdxByKey(K key) {
        // 优化为从map中获取位置
        Integer idx = k2Idx.get(key);
        return idx == null ? -1 : idx;
//        for (int i = 0; i < tail; i++) {
//            if (elements[i].key.equals(key)) {
//                return i;
//            }
//        }
//        return -1;
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
