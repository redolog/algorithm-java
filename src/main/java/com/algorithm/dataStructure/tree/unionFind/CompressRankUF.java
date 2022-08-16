package com.algorithm.dataStructure.tree.unionFind;

/**
 * RankUF 中根据树高来精确判断union时的策略。但是在极端情况下，树仍然会很高，我们可以使用路径压缩的方式将树高压短。
 * <p>
 * CompressRankUF 通过在查询数据时将树高一步步压缩，以此提高了后续数据查询、合并时的效率。
 *
 * @author dragonsong  @date 2022/6/14
 */
public class CompressRankUF {

    /**
     * 数据规模
     */
    int n;
    /**
     * 各元素父节点指针
     */
    int[] parentArr;
    /**
     * 树高
     */
    int[] rankArr;

    public CompressRankUF(int n) {
        this.n = n;
        this.parentArr = new int[n];
        this.rankArr = new int[n];
        for (int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
            rankArr[i] = 0;
        }
    }

    int findRecurse(int i) {
        if (i == parentArr[i]) {
            return i;
        }
        parentArr[i] = findRecurse(parentArr[i]);
        return parentArr[i];
    }

    int findTraverse(int i) {
        while (parentArr[i] != i) {
            // 当前节点的父直接指向父的父
            parentArr[i] = parentArr[parentArr[i]];
            i = parentArr[i];
        }
        return i;
    }

    boolean isConnected(int p, int q) {
        if (p == q) {
            return true;
        }
        return findRecurse(p) == findRecurse(q);
    }

    void union(int p, int q) {
        int pRoot = findRecurse(p);
        int qRoot = findRecurse(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rankArr[pRoot] > rankArr[qRoot]) {
            parentArr[qRoot] = pRoot;
        } else if (rankArr[pRoot] < rankArr[qRoot]) {
            parentArr[pRoot] = qRoot;
        } else {
            parentArr[pRoot] = qRoot;
            // 树高+1
            rankArr[qRoot] += 1;
        }
    }
}
