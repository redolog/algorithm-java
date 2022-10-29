package com.algorithm.dataStructure.array;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountItemsMatchingARuleTest {

    @Test
    public void countMatches() {
        CountItemsMatchingARule service = new CountItemsMatchingARule();
        assertEquals(1, service.countMatches(CollectionUtils.matrixArr2List(new String[][]{{"phone", "blue", "pixel"}, {"computer", "silver", "lenovo"}, {"phone", "gold", "iphone"}}), "color", "silver"));
        assertEquals(2, service.countMatches(CollectionUtils.matrixArr2List(new String[][]{{"phone", "blue", "pixel"}, {"computer", "silver", "phone"}, {"phone", "gold", "iphone"}}), "type", "phone"));
    }
}