package com.algorithm.dataStructure.graph.weight;

/**
 * @param <Weight> 权重泛型
 */
public interface WeightedGraph<Weight extends Number & Comparable> {

    /**
     * @return 获取图顶点数
     */
    int getVertexCnt();

    /**
     * @return 获取图边数
     */
    int getEdgeCnt();

    /**
     * ab两点间添加一条边，附带权重
     *
     * @param a      第一个点
     * @param b      第二个点
     * @param weight 权重
     */
    void addEdge(int a, int b, Weight weight);


    void addEdge(WeightedEdge<Weight> weightedEdge);

    /**
     * 检查a、b两点间是否有边
     */
    boolean hasEdge(int a, int b);

    /**
     * 返回a点相邻的所有顶点
     *
     * @param a 起点
     */
    Iterable<WeightedEdge<Weight>> getAdjacentVertexes(int a);

    /**
     * 按行列格式打印图数据
     */
    void printGraph();
}
