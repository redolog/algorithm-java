package com.algorithm.string;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class FindCommonCharactersTest {

    @Test
    public void commonChars() {
        FindCommonCharacters service = new FindCommonCharacters();
        assertTrue(CollectionUtils.equals(Arrays.asList("e", "l", "l"), service.commonChars(new String[]{"bella", "label", "roller"})));
        assertTrue(CollectionUtils.equals(Arrays.asList("c", "o"), service.commonChars(new String[]{"cool", "lock", "cook"})));
    }
}