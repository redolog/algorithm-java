package com.algorithm.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用邻接矩阵实现一个稠密图
 * 稠密图：大多数点边数接近最大边数
 *
 * @author dragonsong  @date 2022/6/15
 */
public class DenseGraph implements Graph {
    /**
     * 点数
     */
    int vertexCnt;
    /**
     * 边数
     */
    int edgeCnt;
    /**
     * 是否有向
     */
    boolean directed;
    /**
     * 二维数组矩阵，matrix[i][j] 表示 i-》j相连
     */
    boolean[][] matrix;

    public DenseGraph(int vertexCnt, boolean directed) {
        this.vertexCnt = vertexCnt;
        // 初始化边数为0
        this.edgeCnt = 0;
        this.directed = directed;
        this.matrix = new boolean[vertexCnt][vertexCnt];
    }

    public int getVertexCnt() {
        return vertexCnt;
    }

    public int getEdgeCnt() {
        return edgeCnt;
    }

    /**
     * ab两点间添加一条边
     *
     * @param a 第一个点
     * @param b 第二个点
     */
    public void addEdge(int a, int b) {
        assert a >= 0 && a < vertexCnt && b >= 0 && b < vertexCnt;

        if (hasEdge(a, b)) {
            return;
        }

        matrix[a][b] = true;
        if (a != b && !directed) {
            // 无向图，同时需要写 b->a
            matrix[b][a] = true;
        }

        ++edgeCnt;
    }

    public boolean hasEdge(int a, int b) {
        assert a >= 0 && a < vertexCnt && b >= 0 && b < vertexCnt;
        return matrix[a][b];
    }

    /**
     * 返回a点相邻的所有顶点
     *
     * @param a 起点
     */
    public Iterable<Integer> getAdjacentVertexes(int a) {
        assert a >= 0 && a < vertexCnt;
        boolean[] aRow = matrix[a];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < aRow.length; i++) {
            if (aRow[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public void printGraph() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + "->");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
