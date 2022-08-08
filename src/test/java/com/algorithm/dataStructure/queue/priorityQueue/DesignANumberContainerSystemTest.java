package com.algorithm.dataStructure.queue.priorityQueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignANumberContainerSystemTest {

    @Test
    public void testDesignANumberContainerSystem() {
        DesignANumberContainerSystem.NumberContainers nc = new DesignANumberContainerSystem.NumberContainers();
        assertEquals(-1, nc.find(10)); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        assertEquals(1, nc.find(10)); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        assertEquals(2, nc.find(10)); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.


        DesignANumberContainerSystem.NumberContainers2 nc2 = new DesignANumberContainerSystem.NumberContainers2();
        assertEquals(-1, nc2.find(10)); // There is no index that is filled with number 10. Therefore, we return -1.
        nc2.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc2.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc2.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc2.change(5, 10); // Your container at index 5 will be filled with number 10.
        assertEquals(1, nc2.find(10)); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc2.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        assertEquals(2, nc2.find(10)); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
    }

}