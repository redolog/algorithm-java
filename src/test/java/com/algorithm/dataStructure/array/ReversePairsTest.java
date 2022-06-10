package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePairsTest {

    @Test
    public void reversePairs() {
        Assert.assertEquals(5,new ReversePairs().reversePairs(new int[]{7,5,6,4}));
    }
}