package com.algorithm.lookup;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class FindAllDuplicatesInAArrayTest {

    @Test
    public void findDuplicates() {
        FindAllDuplicatesInAArray service = new FindAllDuplicatesInAArray();
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3), service.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
        assertTrue(CollectionUtils.equals(Collections.singletonList(1), service.findDuplicates(new int[]{1, 1, 2})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), service.findDuplicates(new int[]{1})));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3), service.findDuplicates2(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
        assertTrue(CollectionUtils.equals(Collections.singletonList(1), service.findDuplicates2(new int[]{1, 1, 2})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), service.findDuplicates2(new int[]{1})));
        assertTrue(CollectionUtils.equals(Arrays.asList(2, 3), service.findDuplicates3(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
        assertTrue(CollectionUtils.equals(Collections.singletonList(1), service.findDuplicates3(new int[]{1, 1, 2})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), service.findDuplicates3(new int[]{1})));
    }
}