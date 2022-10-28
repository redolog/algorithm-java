package com.algorithm.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasingTest {

    @Test
    public void canBeIncreasing() {
        RemoveOneElementToMakeTheArrayStrictlyIncreasing service = new RemoveOneElementToMakeTheArrayStrictlyIncreasing();
        assertTrue(service.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        assertFalse(service.canBeIncreasing(new int[]{2, 3, 1, 2}));
        assertFalse(service.canBeIncreasing(new int[]{1, 1, 1}));
        assertTrue(service.canBeIncreasing(new int[]{1, 2, 3}));
        assertTrue(service.canBeIncreasing(new int[]{105, 924, 32, 968}));
        assertFalse(service.canBeIncreasing(new int[]{100, 21, 3}));
        assertTrue(service.canBeIncreasing(new int[]{512, 867, 904, 997, 403}));
        assertTrue(service.canBeIncreasing(new int[]{100, 21, 100}));
        assertTrue(service.canBeIncreasing(new int[]{962, 23, 27, 555}));
        assertFalse(service.canBeIncreasing(new int[]{89, 384, 691, 680, 111, 756}));
    }
}