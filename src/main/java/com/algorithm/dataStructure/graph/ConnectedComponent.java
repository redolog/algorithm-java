package com.algorithm.dataStructure.graph;

/**
 * 连通分量
 *
 * @author dragonsong  @date 2022/6/15
 */
public class ConnectedComponent {

    /**
     * 待处理的图实例
     */
    Graph graph;
    /**
     * 连通分量计数
     */
    int cnt;
    /**
     * 使用dfs的方式遍历，使用数组记录每个节点的访问状态
     */
    boolean[] visited;

    /**
     * 点对应连通分量的值，如果分量值相同是，说明是在一张连通的图上
     */
    int[] vertexConnectedComponentCnt;

    public ConnectedComponent(Graph graph) {
        this.graph = graph;
        this.cnt = 0;
        int vertexCnt = graph.getVertexCnt();
        this.visited = new boolean[vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            visited[i] = false;
        }
        vertexConnectedComponentCnt = new int[vertexCnt];

        this.calculateCnt();
    }

    /**
     * @return 获取连通分量数
     */
    public int getCnt() {
        return cnt;
    }

    private void calculateCnt() {
        int vertexCnt = graph.getVertexCnt();
        for (int i = 0; i < vertexCnt; i++) {
            // 未被访问过
            if (!visited[i]) {
                dfs(i);
                ++cnt;
            }
        }
    }

    private void dfs(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        vertexConnectedComponentCnt[i] = getCnt();

        Iterable<Integer> adjacentVertexes = graph.getAdjacentVertexes(i);
        for (Integer vertex : adjacentVertexes) {
            dfs(vertex);
        }
    }

    public boolean isConnected(int a, int b) {
        return vertexConnectedComponentCnt[a] == vertexConnectedComponentCnt[b];
    }
}
