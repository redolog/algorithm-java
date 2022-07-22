package com.algorithm.hash.consistentHash;

import com.algorithm.constant.Const;
import com.algorithm.util.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConsistentHashCoordinatorTest {

    @Test
    public void testConsistentHashCoordinator() {
        int virtualCnt = Const.PRECISION;
        // 一个真实节点生成 virtualCnt 个虚拟节点映射，保证足够均匀分布
        ConsistentHashCoordinator consistentHashCoordinator = new ConsistentHashCoordinator(Node.initClusterNodes(), virtualCnt);
        int n = Const.DATA_SIZE;
        for (int i = 0; i < n; i++) {
            consistentHashCoordinator.put("key" + i, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            assertEquals(i, consistentHashCoordinator.getValueByKey("key" + i));
        }
        System.out.println("==============");
        consistentHashCoordinator.print();
        System.out.println("==============");

        Assert.assertTrue(NumberUtils.nearlyEquals(n, new ArrayList<>(consistentHashCoordinator.node2ReadCnt.values())));

        Node node1 = new Node("ip1", 8088);
        Node node4 = new Node("ip4", 8078);
        consistentHashCoordinator.removeNode(node1);
        consistentHashCoordinator.removeNode(node4);

        consistentHashCoordinator.clearRead();
        for (int i = n - 1; i >= 0; i--) {
            assertEquals(i, consistentHashCoordinator.getValueByKey("key" + i));
        }
        System.out.println("==============");
        consistentHashCoordinator.print();
        System.out.println("==============");
        Node node8 = new Node("ip8", 9999);
        consistentHashCoordinator.addNode(node8);

        consistentHashCoordinator.clearRead();
        for (int i = n - 1; i >= 0; i--) {
            assertEquals(i, consistentHashCoordinator.getValueByKey("key" + i));
        }
        System.out.println("==============");
        consistentHashCoordinator.print();
        System.out.println("==============");
    }
}