package com.algorithm.string.anagram;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindAnagramsTest {

    @Test
    public void findAnagrams() {
        FindAnagrams service = new FindAnagrams();
        assertTrue(CollectionUtils.equals(service.findAnagrams("cbaebabacd", "abc"), Arrays.asList(0, 6)));
    }
}