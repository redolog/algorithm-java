package com.algorithm.string;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class StringMatchingInAnArrayTest {

    @Test
    public void stringMatching() {
        StringMatchingInAnArray service = new StringMatchingInAnArray();
        assertTrue(CollectionUtils.equals(Arrays.asList("as", "hero"), service.stringMatching(new String[]{"mass", "as", "hero", "superhero"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("et", "code"), service.stringMatching(new String[]{"leetcode", "et", "code"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("leetcode", "od", "am"), service.stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), service.stringMatching(new String[]{"blue", "green", "bu"})));
        StringMatchingInAnArray.Join join = new StringMatchingInAnArray.Join();
        assertTrue(CollectionUtils.equals(Arrays.asList("as", "hero"), join.stringMatching(new String[]{"mass", "as", "hero", "superhero"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("et", "code"), join.stringMatching(new String[]{"leetcode", "et", "code"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("leetcode", "od", "am"), join.stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"})));
        assertTrue(CollectionUtils.equals(Collections.emptyList(), join.stringMatching(new String[]{"blue", "green", "bu"})));
    }
}