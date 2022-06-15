package com.algorithm.dataStructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏图：可使用矩阵或者链表实现
 * <p>
 * 稀疏：图中大多数边少于图中可有的最多的边
 *
 * @author dragonsong  @date 2022/6/15
 */
public class SparseGraph implements Graph {
    /**
     * 顶点数
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
     * 邻接矩阵
     */
    List<Integer>[] matrix;

    @SuppressWarnings("unchecked")
    public SparseGraph(int vertexCnt, boolean directed) {
        this.vertexCnt = vertexCnt;
        this.edgeCnt = 0;
        this.directed = directed;
        this.matrix = new List[vertexCnt];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new ArrayList<>();
        }
    }

    public int getVertexCnt() {
        return vertexCnt;
    }

    public int getEdgeCnt() {
        return edgeCnt;
    }

    public boolean hasEdge(int a, int b) {
        assert a >= 0 && a < vertexCnt;
        assert b >= 0 && b < vertexCnt;

        List<Integer> l = matrix[a];
        for (Integer num : l) {
            if (num == b) {
                return true;
            }
        }
        return false;
    }

    public void addEdge(int a, int b) {
        assert a >= 0 && a < vertexCnt;
        assert b >= 0 && b < vertexCnt;
        if (a == b) {
            return;
        }
        matrix[a].add(b);
        if (!directed) {
            matrix[b].add(a);
        }
        edgeCnt++;
    }

    /**
     * 返回a点相邻的节点集合
     *
     * @param a 起点
     */
    public Iterable<Integer> getAdjacentVertexes(int a) {
        assert a >= 0 && a < vertexCnt;
        return matrix[a];
    }

    public void printGraph() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < matrix[i].size(); j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
