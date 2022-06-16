package com.algorithm.dataStructure.graph;

import com.algorithm.util.NumberUtils;
import org.junit.Test;

public class PathTest {

    @Test
    public void printPath() {
        int vertexCnt = 100;
        int edgeCnt = 500;

        DenseGraph denseGraph = new DenseGraph(vertexCnt, true);

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

        System.out.println("a==" + a);
        System.out.println("b==" + b);
        Path path = new Path(a, denseGraph);
        path.printPath(b);
    }
}