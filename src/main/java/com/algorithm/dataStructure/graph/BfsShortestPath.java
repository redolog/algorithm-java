package com.algorithm.dataStructure.graph;

import java.util.*;

/**
 * 无权图、无向图最短路径计算
 * <p>
 * bfs 可求无权图的最短路径
 *
 * @author dragonsong  @date 2022/6/17
 */
public class BfsShortestPath {

    private static final int INIT = -1;

    /**
     * 起点
     */
    int startVertex;
    /**
     * 待计算的图实例
     */
    Graph graph;
    /**
     * 记录路径已经访问过的节点
     */
    boolean[] visited;
    /**
     * 路径上一个节点
     */
    int[] prev;
    /**
     * 每个点距起点的最短距离
     */
    int[] distance;

    public BfsShortestPath(int startVertex, Graph graph) {
        this.startVertex = startVertex;
        this.graph = graph;

        int vertexCnt = graph.getVertexCnt();
        visited = new boolean[vertexCnt];
        Arrays.fill(visited, false);

        prev = new int[vertexCnt];
        Arrays.fill(prev, INIT);
        distance = new int[vertexCnt];
        Arrays.fill(distance, INIT);

        bfs();
    }

    /**
     * 从起点取出相邻节点，入队（已经访问状态）、出队（消费）、计算距离
     */
    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        distance[startVertex] = 0;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Integer currVertex = queue.poll();
            if (currVertex != null) {
                Iterable<Integer> adjacentVertexes = graph.getAdjacentVertexes(currVertex);
                for (Integer nextVertex : adjacentVertexes) {
                    if (visited[nextVertex]) {
                        continue;
                    }
                    prev[nextVertex] = currVertex;
                    visited[nextVertex] = true;
                    distance[nextVertex] = distance[currVertex] + 1;
                    queue.offer(nextVertex);
                }
            }
        }
    }

    public boolean hasPath(int a) {
        // range check
        return visited[a];
    }

    public List<Integer> collectPath(int endVertex) {
        // range check
        if (!visited[endVertex]) {
            return new ArrayList<>(0);
        }

        Deque<Integer> stack = new LinkedList<>();

        int curr = endVertex;
        while (INIT != curr) {
            stack.push(curr);
            curr = prev[curr];
        }

        List<Integer> pathList = new LinkedList<>();
        while (!stack.isEmpty()) {
            pathList.add(stack.pop());
        }
        return pathList;
    }

    public void printPath(int endVertex) {
        collectPath(endVertex).forEach(v -> System.out.print(v + "-->"));
        System.out.println();
    }

    public void printDistance(int endVertex) {
        System.out.println(distance[endVertex]);
    }

}
