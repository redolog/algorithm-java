package com.algorithm.dataStructure.graph;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

public class DenseGraphTest {

    @Test
    public void getAdjacentVertexes() {
        int vertexCnt = 100;
        int edgeCnt = 500;

        DenseGraph denseGraph = new DenseGraph(vertexCnt, true);

        for (int i = 0; i < edgeCnt; i++) {
            int a = NumberUtils.randomIndex(vertexCnt);
            int b = NumberUtils.randomIndex(vertexCnt);
            denseGraph.addEdge(a, b);
        }
        denseGraph.printGraph();

    }
}