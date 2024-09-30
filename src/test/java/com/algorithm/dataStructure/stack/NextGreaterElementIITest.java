package com.algorithm.dataStructure.stack;

import junit.framework.TestCase;
import org.junit.Assert;

public class NextGreaterElementIITest extends TestCase {

    public void testNextGreaterElements() {
        NextGreaterElementII service = new NextGreaterElementII();
        Assert.assertArrayEquals(new int[]{120, 11, 120, 120, 123, 123, -1, 100, 100, 100}, service.nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100}));
    }
}