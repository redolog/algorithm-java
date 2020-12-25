package com.algorithm.dp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContainerWithMostWaterTest {

    ContainerWithMostWater service;

    @Before
    public void setUp() throws Exception {
        service = new ContainerWithMostWater();
    }

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * <p>
     * 输入：height = [1,1]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     * 示例 4：
     * <p>
     * 输入：height = [1,2,1]
     * 输出：2
     */
    @Test
    public void maxArea() {
        Assert.assertEquals(49, service.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, service.maxArea(new int[]{1, 1}));
        Assert.assertEquals(16, service.maxArea(new int[]{4, 3, 2, 1, 4}));
        Assert.assertEquals(2, service.maxArea(new int[]{1, 2, 1}));
    }
}