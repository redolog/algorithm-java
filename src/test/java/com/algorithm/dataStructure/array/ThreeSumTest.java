package com.algorithm.dataStructure.array;

import org.junit.Before;
import org.junit.Test;

public class ThreeSumTest {

    ThreeSum service;

    @Before
    public void setUp() throws Exception {
        service = new ThreeSum();
    }

    @Test
    public void solution() {
        service.solution(new int[]{1, 3, 2, 3, 4, 4}, 8);
        service.solution(new int[]{1, 3, 2, 3, 4, 4}, 9);
    }
}