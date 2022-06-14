package com.algorithm.dataStructure.tree;

import org.junit.Test;

public class UFTest {

    @Test
    public void compareUF() {
        int n = 100000;
        new QuickFindUFTest().union(n);
        new QuickUFTest().union(n);
        new SizeUFTest().union(n);
        new RankUFTest().union(n);
        new CompressRankUFTest().union(n);
    }
}
