package com.algorithm.dataStructure.graph.weight;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

public class WeightedDenseGraphTest {

    @Test
    public void printGraph() {

        int vertexCnt = 100;
        int edgeCnt = 500;

        WeightedDenseGraph<Double> denseGraph = new WeightedDenseGraph<>(vertexCnt, true);

        for (int i = 0; i < edgeCnt; i++) {
            int a = NumberUtils.randomIndex(vertexCnt);
            int b = NumberUtils.randomIndex(vertexCnt);
            denseGraph.addEdge(a, b, Math.random());
        }
        denseGraph.printGraph();
    }
}