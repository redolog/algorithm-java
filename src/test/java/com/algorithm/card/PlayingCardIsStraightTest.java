package com.algorithm.card;

import org.junit.Assert;
import org.junit.Test;

public class PlayingCardIsStraightTest {

    PlayingCardIsStraight service = new PlayingCardIsStraight();

    @Test
    public void isStraight() {
        Assert.assertTrue(service.isStraight(new int[]{1, 2, 3, 4, 5}));
        Assert.assertTrue(service.isStraight(new int[]{0, 0, 1, 2, 5}));
        Assert.assertFalse(service.isStraight(new int[]{0, 0, 2, 2, 5}));
    }
}