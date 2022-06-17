package com.algorithm.dataStructure.graph;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

public class BfsShortestPathTest {

    @Test
    public void printDistance() {
        int vertexCnt = 100;
        int edgeCnt = 500;

        DenseGraph denseGraph = new DenseGraph(vertexCnt, false);

        int a = 0;
        int b = 0;
        for (int i = 0; i < edgeCnt; i++) {
            a = NumberUtils.randomIndex(vertexCnt);
            b = NumberUtils.randomIndex(vertexCnt);
            denseGraph.addEdge(a, b);
        }
        denseGraph.printGraph();

        System.out.println("6666");
        System.out.println();

        b = NumberUtils.randomIndex(vertexCnt);
        System.out.println("a==" + a);
        System.out.println("b==" + b);

        BfsShortestPath shortestPath = new BfsShortestPath(a, denseGraph);
        shortestPath.printPath(b);
        shortestPath.printDistance(b);
    }
}