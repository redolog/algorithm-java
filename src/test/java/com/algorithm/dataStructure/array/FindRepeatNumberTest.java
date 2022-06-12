package com.algorithm.dataStructure.array;

import org.junit.Assert;
import org.junit.Test;

public class FindRepeatNumberTest {

    @Test
    public void findRepeatNumber() {
        Assert.assertEquals(2, new FindRepeatNumber().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}