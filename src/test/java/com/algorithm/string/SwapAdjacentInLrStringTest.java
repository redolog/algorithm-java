package com.algorithm.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SwapAdjacentInLrStringTest {

    @Test
    public void canTransform() {
        SwapAdjacentInLrString service = new SwapAdjacentInLrString();
        // RXXLRXRXL ->
        // XRXLRXRXL -> 替换第一个RX为XR
        // XRLXRXRXL -> 替换第二个XL为LX
        // XR LX XR RXL -> 替换第三个RX为XR
        // XR LX XR R LX -> 替换
        assertTrue(service.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        assertTrue(service.canTransform("XL", "LX"));
        assertTrue(service.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
        // 这个用例说明：L只能左移，不能右移！同理R只能右移，不能左移！
        assertFalse(service.canTransform("LXXLXRLXXL", "XLLXRXLXLX"));
        assertFalse(service.canTransform("X", "L"));
    }
}