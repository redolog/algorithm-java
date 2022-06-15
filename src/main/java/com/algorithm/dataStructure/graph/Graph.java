package com.algorithm.dataStructure.graph;

/**
 * 图接口定义
 *
 * @author dragonsong  @date 2022/6/15
 */
public interface Graph {

    /**
     * @return 获取图顶点数
     */
    int getVertexCnt();

    /**
     * @return 获取图边数
     */
    int getEdgeCnt();

    /**
     * ab两点间添加一条边
     *
     * @param a 第一个点
     * @param b 第二个点
     */
    void addEdge(int a, int b);

    /**
     * 检查a、b两点间是否有边
     */
    boolean hasEdge(int a, int b);

    /**
     * 返回a点相邻的所有顶点
     *
     * @param a 起点
     */
    Iterable<Integer> getAdjacentVertexes(int a);

    /**
     * 按行列格式打印图数据
     */
    void printGraph();
}
