package com.algorithm.dataStructure.tree.unionFind;

/**
 * 快速查找版本的 Union Find 并查集
 * 1. 使用数组存储元素，表示并查集的树；
 * 2. 元素值相同，视为元素是连接的；
 * 3. union合并元素操作：将元素下标指向的值变成相同的；
 *
 * @author dragonsong  @date 2022/6/14
 */
public class QuickFindUF {

    /**
     * 数据集容量
     */
    int capacity;

    /**
     * 使用数组存储元素，
     */
    int[] elements;

    public QuickFindUF(int n) {
        this.capacity = n;
        this.elements = new int[n];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = i;
        }
    }

    /**
     * 复杂度 O(n)
     */
    void union(int p, int q) {
        if (isConnected(p, q)) {
            return;
        }

        // 将p点以及连接的点，都指向 elements[q]
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == find(p)) {
                elements[i] = find(q);
            }
        }
    }

    int find(int i) {
        return elements[i];
    }

    boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}
