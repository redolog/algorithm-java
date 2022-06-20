package com.algorithm.dataStructure.graph;

import org.junit.Assert;
import org.junit.Test;

public class WordSearchTest {

    WordSearch service = new WordSearch();

    @Test
    public void exist() {

        Assert.assertTrue(service.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        Assert.assertTrue(service.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        boolean abcb = service.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
        Assert.assertFalse(abcb);
//
        Assert.assertTrue(service.exist(new char[][]{{'a', 'b'}}, "ba"));
        Assert.assertFalse(service.exist(new char[][]{{'b'}, {'a'}, {'b'}, {'b'}, {'a'}}, "baa"));

    }
}