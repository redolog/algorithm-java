package com.algorithm.string.anagram;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GroupAnagramsTest {

    @Test
    public void groupAnagrams() {
        GroupAnagrams service = new GroupAnagrams();
        List<List<String>> ans1 = CollectionUtils.matrixArr2List(new String[][]{{"bat"}, {"nat", "tan"}, {"ate", "eat", "tea"}});
        assertTrue(CollectionUtils.equals(service.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}), ans1));
    }
}