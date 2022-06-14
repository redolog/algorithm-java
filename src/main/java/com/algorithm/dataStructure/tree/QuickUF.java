package com.algorithm.dataStructure.tree;

/**
 * QuickFindUF 中union的复杂度为 O(n)，QuickUF 来优化这个union
 * <p>
 * 我们同样基于数组表示这棵并查集树，将数组指向尽可能组织起来；
 * 初始时每个元素指向自己，表示为一个根；
 * 查找指向时，沿着树一直向上查找根节点；
 * union合并时，将新节点指向原节点树根，由于union多个节点都指向树根，因此树高远小于总数据量，因此效率提高；
 *
 * @author dragonsong  @date 2022/6/14
 */
public class QuickUF {

    int n;

    int[] parentArr;

    public QuickUF(int n) {
        this.n = n;
        parentArr = new int[n];
        // 初始化数组指向自己
        for (int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
        }
    }

    /**
     * 寻找i元素对应树根
     *
     * @param i 元素下标
     * @return 指向的树根
     */
    int find(int i) {
        // i保证不越界
        // 只要i在树上没到达树根，就一直往上走
        while (parentArr[i] != i) {
            i = parentArr[i];
        }
        return i;
    }

    boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 将q节点指向的树根指向p的树根
     *
     * @param p 前序节点
     * @param q 后继节点
     */
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parentArr[qRoot] = pRoot;
    }
}
