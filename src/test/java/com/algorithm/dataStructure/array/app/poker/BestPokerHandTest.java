package com.algorithm.dataStructure.array.app.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestPokerHandTest {

    @Test
    public void bestHand() {
        BestPokerHand.StreamSolution streamSolution = new BestPokerHand.StreamSolution();
        assertEquals("Flush", streamSolution.bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
        assertEquals("Three of a Kind", streamSolution.bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'}));
        assertEquals("Pair", streamSolution.bestHand(new int[]{10, 10, 2, 12, 9}, new char[]{'a', 'b', 'c', 'a', 'd'}));
        BestPokerHand.CntSolution cntSolution = new BestPokerHand.CntSolution();
        assertEquals("Flush", cntSolution.bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
        assertEquals("Three of a Kind", cntSolution.bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'}));
        assertEquals("Pair", cntSolution.bestHand(new int[]{10, 10, 2, 12, 9}, new char[]{'a', 'b', 'c', 'a', 'd'}));
    }
}