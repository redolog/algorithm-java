package com.algorithm.lookup;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class FindAllNumbersDisappearedInAnArrayTest {

    @Test
    public void findDisappearedNumbers() {
        FindAllNumbersDisappearedInAnArray.InPlaceHash inPlaceHash = new FindAllNumbersDisappearedInAnArray.InPlaceHash();
        assertTrue(CollectionUtils.equals(Arrays.asList(5, 6), inPlaceHash.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
        assertTrue(CollectionUtils.equals(Collections.singletonList(2), inPlaceHash.findDisappearedNumbers(new int[]{1, 1})));

        FindAllNumbersDisappearedInAnArray.BF bf = new FindAllNumbersDisappearedInAnArray.BF();
        assertTrue(CollectionUtils.equals(Arrays.asList(5, 6), bf.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})));
        assertTrue(CollectionUtils.equals(Collections.singletonList(2), bf.findDisappearedNumbers(new int[]{1, 1})));
    }
}