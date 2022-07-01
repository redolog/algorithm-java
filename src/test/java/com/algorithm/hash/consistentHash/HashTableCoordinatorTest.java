package com.algorithm.hash.consistentHash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTableCoordinatorTest {

    @Test
    public void testHashTableCoordinator() {
        HashTableCoordinator hashTableCoordinator = new HashTableCoordinator(Node.initClusterNodes());
        int n = 100000;
        for (int i = 0; i < n; i++) {
            hashTableCoordinator.put("key" + i, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            assertEquals(i, hashTableCoordinator.getValueByKey("key" + i));
        }
    }
}