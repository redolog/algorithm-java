package com.algorithm.backtrack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatrixPathExistTest {

    MatrixPathExist service = new MatrixPathExist();

    @Test
    public void exist() {
        assertTrue(service.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        assertFalse(service.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "abcd"));

        Assert.assertTrue(service.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        Assert.assertTrue(service.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        boolean abcb = service.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
        Assert.assertFalse(abcb);
//
        Assert.assertTrue(service.exist(new char[][]{{'a', 'b'}}, "ba"));
        Assert.assertFalse(service.exist(new char[][]{{'b'}, {'a'}, {'b'}, {'b'}, {'a'}}, "baa"));
    }
}