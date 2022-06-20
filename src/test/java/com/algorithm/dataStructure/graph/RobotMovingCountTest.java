package com.algorithm.dataStructure.graph;

import org.junit.Assert;
import org.junit.Test;

public class RobotMovingCountTest {

    RobotMovingCount service = new RobotMovingCount();

    @Test
    public void movingCount() {
        Assert.assertEquals(8, service.sum(35));
        Assert.assertEquals(7, service.sum(16));
        Assert.assertEquals(8, service.sum(8));
//        Assert.assertEquals(19,service.sum(35)+service.sum(38));
//        Assert.assertEquals(15,service.sum(16)+service.sum(8));

        Assert.assertEquals(3, service.movingCount(2, 3, 1));
        Assert.assertEquals(1, service.movingCount(3, 1, 0));
        Assert.assertEquals(88, service.movingCount(11, 8, 16));
        Assert.assertEquals(15, service.movingCount(16, 8, 4));
    }

    @Test
    public void movingCountDfs() {
        Assert.assertEquals(3, service.movingCountDfs(2, 3, 1));
        Assert.assertEquals(1, service.movingCountDfs(3, 1, 0));
        Assert.assertEquals(88, service.movingCountDfs(11, 8, 16));
        Assert.assertEquals(15, service.movingCountDfs(16, 8, 4));
    }
}