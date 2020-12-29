package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveDuplicatesInArrayTest {

    RemoveDuplicatesInArray service;

    @Before
    public void setUp() throws Exception {
        service = new RemoveDuplicatesInArray();
    }

    @Test
    public void removeDuplicates() {
        int ret = service.removeDuplicates(new int[]{1, 1, 2});
        Assert.assertEquals(2, ret);
    }
}