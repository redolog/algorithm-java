package com.algorithm.dataStructure.array.traverse;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ExclusiveTimeOfFunctionsTest {

    @Test
    public void exclusiveTime() {
        ExclusiveTimeOfFunctions service = new ExclusiveTimeOfFunctions();
        assertArrayEquals(new int[]{3, 4}, service.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
        assertArrayEquals(new int[]{8}, service.exclusiveTime(1, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7")));
        assertArrayEquals(new int[]{7, 1}, service.exclusiveTime(2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7")));
        assertArrayEquals(new int[]{8, 1}, service.exclusiveTime(2, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8")));
        assertArrayEquals(new int[]{1}, service.exclusiveTime(1, Arrays.asList("0:start:0", "0:end:0")));
        assertArrayEquals(new int[]{6}, service.exclusiveTime(1, Arrays.asList("0:start:0", "0:start:1", "0:start:2", "0:end:3", "0:end:4", "0:end:5")));
    }
}