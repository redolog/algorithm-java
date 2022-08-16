package com.algorithm.dataStructure.tree.unionFind;

import com.algorithm.util.NumberUtils;

public class RankUFTest {

//    @Test
    public void union(int n) {

        long start = System.currentTimeMillis();
        RankUF rankUF = new RankUF(n);
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            rankUF.union(pIdx, qIdx);
        }
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            rankUF.isConnected(pIdx, qIdx);
        }
        long end = System.currentTimeMillis();
        System.out.println("RankUFTest 运行 " + n + "次，耗时：" + (end - start) + "ms");
    }
}