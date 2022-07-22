package com.algorithm.dataStructure.tree;

import com.algorithm.util.NumberUtils;

public class CompressRankUFTest {

    public void union(int n) {

        long start = System.currentTimeMillis();
        CompressRankUF rankUF = new CompressRankUF(n);
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
        System.out.println("CompressRankUFTest 运行 " + n + "次，耗时：" + (end - start) + "ms");
    }
}