package com.algorithm.dataStructure.tree;

import com.algorithm.util.NumberUtils;

public class SizeUFTest {

//    @Test
    public void union(int n) {

        long start = System.currentTimeMillis();
        SizeUF sizeUF = new SizeUF(n);
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            sizeUF.union(pIdx, qIdx);
        }
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            sizeUF.isConnected(pIdx, qIdx);
        }
        long end = System.currentTimeMillis();
        System.out.println("SizeUFTest 运行 " + n + "次，耗时：" + (end - start) + "ms");
    }
}