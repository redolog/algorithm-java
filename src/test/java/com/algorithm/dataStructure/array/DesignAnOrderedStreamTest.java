package com.algorithm.dataStructure.array;

import com.algorithm.util.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class DesignAnOrderedStreamTest {

    @Test
    public void testDesignAnOrderedStream() {
        DesignAnOrderedStream.OrderedStream os = new DesignAnOrderedStream.OrderedStream(5);
        assertTrue(CollectionUtils.equals(Collections.emptyList(), os.insert(3, "ccccc")));
        // 插入 (3, "ccccc")，返回 []
        assertTrue(CollectionUtils.equals(Collections.singletonList("aaaaa"), os.insert(1, "aaaaa")));
        // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        assertTrue(CollectionUtils.equals(Arrays.asList("bbbbb", "ccccc"), os.insert(2, "bbbbb")));
        // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        assertTrue(CollectionUtils.equals(Collections.emptyList(), os.insert(5, "eeeee")));
        // 插入 (5, "eeeee")，返回 []
        assertTrue(CollectionUtils.equals(Arrays.asList("ddddd", "eeeee"), os.insert(4, "ddddd")));
        // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }

}