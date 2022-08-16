package com.algorithm.dataStructure.tree.unionFind;

import com.algorithm.util.NumberUtils;

public class QuickUFTest {

//    @Test
    public void union(int n) {

        long start = System.currentTimeMillis();
        QuickUF quickUF = new QuickUF(n);
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            quickUF.union(pIdx, qIdx);
        }
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            quickUF.isConnected(pIdx, qIdx);
        }
        long end = System.currentTimeMillis();
        System.out.println("QuickUFTest 运行 " + n + "次，耗时：" + (end - start) + "ms");
    }
}