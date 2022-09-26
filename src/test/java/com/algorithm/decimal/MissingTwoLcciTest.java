package com.algorithm.decimal;

import com.algorithm.util.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MissingTwoLcciTest {

    @Test
    public void missingTwo() {
        MissingTwoLcci.MapSolution mapSolution = new MissingTwoLcci.MapSolution();
        assertTrue(ArrayUtils.containEquals(mapSolution.missingTwo(new int[]{1}), new int[]{2, 3}));
        assertTrue(ArrayUtils.containEquals(mapSolution.missingTwo(new int[]{2, 3}), new int[]{1, 4}));
        MissingTwoLcci.GeometricProgression geometricProgression = new MissingTwoLcci.GeometricProgression();
        assertTrue(ArrayUtils.containEquals(geometricProgression.missingTwo(new int[]{1}), new int[]{2, 3}));
        assertTrue(ArrayUtils.containEquals(geometricProgression.missingTwo(new int[]{2, 3}), new int[]{1, 4}));
    }
}