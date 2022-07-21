package com.algorithm.dataStructure.matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteColumnToMakeSortedTest {

    @Test
    public void minDeletionSize() {
        DeleteColumnToMakeSorted.SetSolution setSolution = new DeleteColumnToMakeSorted.SetSolution();
        assertEquals(1, setSolution.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        assertEquals(0, setSolution.minDeletionSize(new String[]{"a", "b"}));
        assertEquals(3, setSolution.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));

        DeleteColumnToMakeSorted.CntSolution cntSolution = new DeleteColumnToMakeSorted.CntSolution();
        assertEquals(1, cntSolution.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        assertEquals(0, cntSolution.minDeletionSize(new String[]{"a", "b"}));
        assertEquals(3, cntSolution.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }
}