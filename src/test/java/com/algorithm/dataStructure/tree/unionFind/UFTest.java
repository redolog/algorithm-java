package com.algorithm.dataStructure.tree.unionFind;

import com.algorithm.constant.Const;
import org.junit.Test;

public class UFTest {

    @Test
    public void compareUF() {
        int n = Const.DATA_SIZE;
        new QuickFindUFTest().union(n);
        new QuickUFTest().union(n);
        new SizeUFTest().union(n);
        new RankUFTest().union(n);
        new CompressRankUFTest().union(n);
    }
}
