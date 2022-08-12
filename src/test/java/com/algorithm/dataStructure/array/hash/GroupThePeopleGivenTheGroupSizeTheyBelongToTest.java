package com.algorithm.dataStructure.array.hash;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class GroupThePeopleGivenTheGroupSizeTheyBelongToTest {

    @Test
    public void groupThePeople() {
        GroupThePeopleGivenTheGroupSizeTheyBelongTo service = new GroupThePeopleGivenTheGroupSizeTheyBelongTo();
        assertTrue(CollectionUtils.equals(Arrays.asList(Collections.singletonList(5), Arrays.asList(0, 1, 2), Arrays.asList(3, 4, 6)), service.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3})));
        assertTrue(CollectionUtils.equals(Arrays.asList(Collections.singletonList(1), Arrays.asList(0, 5), Arrays.asList(2, 3, 4)), service.groupThePeople(new int[]{2, 1, 3, 3, 3, 2})));
    }
}