package com.algorithm.backtrack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermutationSequenceTest {

    @Test
    public void getPermutation() {
        PermutationSequence service = new PermutationSequence();
//        String permutation = service.getPermutation(3, 3);
//        System.out.println(permutation);

        assertEquals("213", service.getPermutation(3, 3));
        assertEquals("2314", service.getPermutation(4, 9));

    }
}