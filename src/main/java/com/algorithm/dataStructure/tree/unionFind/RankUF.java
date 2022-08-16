package com.algorithm.dataStructure.tree.unionFind;

/**
 * SizeUF 中根据树元素个数做了union时的优化，防止将更多元素的树合并到更少元素的树上，但是带来一个问题：
 * 根据元素个数判断树高是不准确的，而find查找元素时，决定复杂度的是树高，因此 RankUF 中，我们优化 SizeUF size的逻辑。
 *
 * @author dragonsong  @date 2022/6/14
 */
public class RankUF {
    /**
     * 并查集元素总量
     */
    int n;
    /**
     * 元素指向父的指针
     */
    int[] parentArr;
    /**
     * 当前节点（下标）对应集合树高，树高决定了find查找的复杂度，使用树高优化 SizeUF 带来的问题
     */
    int[] hArr;

    public RankUF(int n) {
        this.n = n;
        this.parentArr = new int[n];
        this.hArr = new int[n];
        for (int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
            hArr[i] = 0;
        }
    }

    /**
     * 查找i下标所在集合的根
     */
    int find(int i) {
        // 保证i数组下标范围
        while (parentArr[i] != i) {
            i = parentArr[i];
        }
        return i;
    }

    /**
     * @param p p点下标
     * @param q q点下标
     * @return p所在树根==q所在树根时，表示p、q对应元素在同一集合内！
     */
    boolean isConnected(int p, int q) {
        if (p == q) {
            return true;
        }
        return find(p) == find(q);
    }

    void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (hArr[pRoot] > hArr[qRoot]) {
            _union(pRoot, qRoot);
        } else if (hArr[pRoot] < hArr[qRoot]) {
            _union(qRoot, pRoot);
        } else {
            _union(pRoot, qRoot);
            hArr[pRoot] += 1;
        }
    }

    /**
     * 将更矮的树合并到更高的树上
     *
     * @param higherRoot 更高树根
     * @param lowerRoot  更矮树根
     */
    private void _union(int higherRoot, int lowerRoot) {
        parentArr[lowerRoot] = higherRoot;
    }
}
