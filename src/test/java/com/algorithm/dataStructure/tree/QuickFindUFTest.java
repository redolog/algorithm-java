package com.algorithm.dataStructure.tree;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

public class QuickFindUFTest {

    @Test
    public void union(int n) {

        long start = System.currentTimeMillis();
        QuickFindUF quickFindUF = new QuickFindUF(n);
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            quickFindUF.union(pIdx, qIdx);
        }
        for (int i = 0; i < n; i++) {
            int pIdx = NumberUtils.randomIndex(n);
            int qIdx = NumberUtils.randomIndex(n);
            quickFindUF.isConnected(pIdx, qIdx);
        }
        long end = System.currentTimeMillis();
        System.out.println("QuickFindUFTest 运行 " + n + "次，耗时：" + (end - start) + "ms");

    }
}