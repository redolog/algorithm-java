package com.algorithm.dataStructure.graph.weight;

import java.util.Arrays;

/**
 * 有权稠密图
 *
 * @author dragonsong  @date 2022/6/17
 */
public class WeightedDenseGraph<Weight extends Number & Comparable> implements WeightedGraph<Weight> {
    /**
     * 点数
     */
    int vertexCnt;
    /**
     * 边数
     */
    int edgeCnt;
    /**
     * 是否有方向
     */
    boolean directed;
    /**
     * 图具体数据
     */
    WeightedEdge<Weight>[][] matrix;

    @SuppressWarnings("unchecked")
    public WeightedDenseGraph(int vertexCnt, boolean directed) {
        this.vertexCnt = vertexCnt;
        this.edgeCnt = 0;
        this.directed = directed;

        matrix = new WeightedEdge[vertexCnt][vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            for (int j = 0; j < vertexCnt; j++) {
                matrix[i][j] = null;
            }
        }
    }

    @Override
    public int getVertexCnt() {
        return vertexCnt;
    }

    @Override
    public int getEdgeCnt() {
        return edgeCnt;
    }

    @Override
    public void addEdge(int a, int b, Weight weight) {
        addEdge(new WeightedEdge<>(a, b, weight));
    }

    @Override
    public void addEdge(WeightedEdge<Weight> weightedEdge) {
        int a = weightedEdge.getA();
        int b = weightedEdge.getB();
        if (hasEdge(a, b)) {
            return;
        }
        matrix[a][b] = weightedEdge;
        if (a != b && !directed) {
            matrix[b][a] = weightedEdge;
        }
        ++edgeCnt;
    }

    @Override
    public boolean hasEdge(int a, int b) {
        return matrix[a][b] != null;
    }

    @Override
    public Iterable<WeightedEdge<Weight>> getAdjacentVertexes(int a) {
        return Arrays.asList(matrix[a]);
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < vertexCnt; i++) {
            for (int j = 0; j < vertexCnt; j++) {
                System.out.print(matrix[i][j] + "-->");
            }
            System.out.println();
        }
    }
}
