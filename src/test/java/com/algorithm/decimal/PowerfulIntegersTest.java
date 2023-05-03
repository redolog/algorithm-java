package com.algorithm.decimal;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class PowerfulIntegersTest {

    @Test
    public void powerfulIntegers() {
        PowerfulIntegers.BFSolution bfSolution = new PowerfulIntegers.BFSolution();
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3, 4, 5, 7, 9, 10), bfSolution.powerfulIntegers(2, 3, 10)));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 4, 6, 8, 10, 14), bfSolution.powerfulIntegers(3, 5, 15)));
        PowerfulIntegers.EnumerationSolution enumerationSolution = new PowerfulIntegers.EnumerationSolution();
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3, 4, 5, 7, 9, 10), enumerationSolution.powerfulIntegers(2, 3, 10)));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 4, 6, 8, 10, 14), enumerationSolution.powerfulIntegers(3, 5, 15)));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3, 4, 5, 7, 9, 10), enumerationSolution.powerfulIntegers(2, 3, 10)));
    }
}