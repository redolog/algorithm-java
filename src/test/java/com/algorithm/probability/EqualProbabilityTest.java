package com.algorithm.probability;

import com.algorithm.constant.Const;
import com.algorithm.util.NumberUtils;
import com.algorithm.util.ProbabilityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EqualProbabilityTest {

    int cnt = Const.DATA_SIZE;
    int precision = Const.PRECISION;


    @Test
    public void epBaseRand01() {

        int[] randCounts = ProbabilityUtils.runStoreEpCnts(
                cnt,
                0, 1,
                EP::epBaseRand01
        );

        System.out.println(Arrays.toString(randCounts));

        Assert.assertTrue(NumberUtils.nearlyEquals(precision, randCounts));
    }

    @Test
    public void epBaseRand15() {
        int[] randCounts = ProbabilityUtils.runStoreEpCnts(
                cnt,
                0, 1,
                EP::epBaseRand15
        );

        System.out.println(Arrays.toString(randCounts));

        Assert.assertTrue(NumberUtils.nearlyEquals(precision, randCounts));
    }

    @Test
    public void epRand07() {
        int[] randCounts = ProbabilityUtils.runStoreEpCnts(
                cnt,
                0, 7,
                Rand2Rand::rand07
        );

        System.out.println(Arrays.toString(randCounts));

        Assert.assertTrue(NumberUtils.nearlyEquals(precision, randCounts));
    }
    @Test
    public void epRand17() {
        int[] randCounts = ProbabilityUtils.runStoreEpCnts(
                cnt,
                1, 7,
                Rand2Rand::rand17
        );

        System.out.println(Arrays.toString(randCounts));

        Assert.assertTrue(NumberUtils.nearlyEquals(precision, randCounts));
    }

}