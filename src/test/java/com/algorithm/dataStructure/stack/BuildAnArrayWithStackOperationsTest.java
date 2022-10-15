package com.algorithm.dataStructure.stack;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BuildAnArrayWithStackOperationsTest {

    @Test
    public void buildArray() {
        BuildAnArrayWithStackOperations service = new BuildAnArrayWithStackOperations();
        assertTrue(CollectionUtils.equals(Arrays.asList("Push", "Push", "Pop", "Push"), service.buildArray(new int[]{1, 3}, 3)));
        assertTrue(CollectionUtils.equals(Arrays.asList("Push", "Push", "Push"), service.buildArray(new int[]{1, 2, 3}, 3)));
        assertTrue(CollectionUtils.equals(Arrays.asList("Push", "Push"), service.buildArray(new int[]{1, 2}, 4)));
    }
}