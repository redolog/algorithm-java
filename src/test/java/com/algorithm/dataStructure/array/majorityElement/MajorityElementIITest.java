package com.algorithm.dataStructure.array.majorityElement;

import com.algorithm.util.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class MajorityElementIITest {

    @Test
    public void testMajorityElementII() {
        MajorityElementII.MooreVoteSolution mooreVoteSolution = new MajorityElementII.MooreVoteSolution();
        Assert.assertTrue(CollectionUtils.equals(mooreVoteSolution.majorityElement(new int[]{3, 3, 4}), Collections.singletonList(3)));
        Assert.assertTrue(CollectionUtils.equals(mooreVoteSolution.majorityElement(new int[]{2, 2, 1, 3}), Collections.singletonList(2)));
        MajorityElementII.MapCntSolution mapCntSolution = new MajorityElementII.MapCntSolution();
        Assert.assertTrue(CollectionUtils.equals(mapCntSolution.majorityElement(new int[]{3, 3, 4}), Collections.singletonList(3)));
        Assert.assertTrue(CollectionUtils.equals(mapCntSolution.majorityElement(new int[]{2, 2, 1, 3}), Collections.singletonList(2)));
    }

}