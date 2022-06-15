package com.algorithm.dataStructure.graph;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

public class SparseGraphTest {

    @Test
    public void printGraph() {
        int vertexCnt = 100;
        int edgeCnt = 200;

        SparseGraph sparseGraph = new SparseGraph(vertexCnt, true);
        for (int i = 0; i < edgeCnt; i++) {
            int a = NumberUtils.randomIndex(vertexCnt);
            int b = NumberUtils.randomIndex(vertexCnt);
            sparseGraph.addEdge(a, b);
        }

        sparseGraph.printGraph();
    }
}