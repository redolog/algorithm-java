package com.algorithm.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BulbSwitcherTest {

    @Test
    public void bulbSwitch() {
        BulbSwitcher service = new BulbSwitcher();
        assertEquals(service.bulbSwitch2(3), service.bulbSwitch(3));
        assertEquals(service.bulbSwitch2(0), service.bulbSwitch(0));
        assertEquals(service.bulbSwitch2(1), service.bulbSwitch(1));
        assertEquals(service.bulbSwitch2(99999), service.bulbSwitch(99999));
    }
}