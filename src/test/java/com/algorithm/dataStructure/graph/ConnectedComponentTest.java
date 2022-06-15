package com.algorithm.dataStructure.graph;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

public class ConnectedComponentTest {

    @Test
    public void getCnt() {
        int vertexCnt = 100;
        int edgeCnt = 50;

        SparseGraph sparseGraph = new SparseGraph(vertexCnt, true);
        for (int i = 0; i < edgeCnt; i++) {
            int a = NumberUtils.randomIndex(vertexCnt);
            int b = NumberUtils.randomIndex(vertexCnt);
            sparseGraph.addEdge(a, b);
        }
        sparseGraph.printGraph();

        ConnectedComponent connectedComponent = new ConnectedComponent(sparseGraph);

        System.out.println(connectedComponent.getCnt());

    }
}