package com.algorithm.dataStructure.tree.unionFind;

/**
 * QuickUF 中我们每次union时很可能会将一棵较高的树，并到一棵较低的树上，这样其实总的树高是变高了，复杂度因此而攀升。
 * SizeUF 中我们每次union都可以判断下集合元素数，每次将元素较少的树并到较多的树上，这样总的树高可以得到控制。
 *
 * @author dragonsong  @date 2022/6/14
 */
public class SizeUF {

    /**
     * 并查集总数据量
     */
    int n;
    /**
     * 记录每个元素（实际是下标）对应父元素，根指向自己
     */
    int[] parentArr;
    /**
     * 记录每个元素（实际是下标）对应并集元素数量，供union时判断
     */
    int[] sizeArr;

    public SizeUF(int n) {
        this.n = n;
        this.parentArr = new int[n];
        this.sizeArr = new int[n];
        for (int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
            sizeArr[i] = 1;
        }
    }

    int find(int i) {
        // 需保证i不越界
        while (parentArr[i] != i) {
            i = parentArr[i];
        }
        return i;
    }

    boolean isConnected(int p, int q) {
        if (p == q) {
            return true;
        }
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (sizeArr[pRoot] < sizeArr[qRoot]) {
            _union(qRoot, pRoot);
        } else {
            _union(pRoot, qRoot);
        }
    }

    /**
     * 将元素更少的树并到元素更多的树根上
     *
     * @param more 多元素树根
     * @param less 少元素树根
     */
    void _union(int more, int less) {
        parentArr[less] = parentArr[more];
        // 更少元素的树并到更多元素的树上，此时更少元素的根统一由 more 下标根负责，叠加less子树上的元素数
        sizeArr[more] += sizeArr[less];
    }
}
