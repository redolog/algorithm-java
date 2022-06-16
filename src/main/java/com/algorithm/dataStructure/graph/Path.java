package com.algorithm.dataStructure.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径：寻路
 *
 * @author dragonsong  @date 2022/6/16
 */
public class Path {
    /**
     * 还没访问过的记录
     */
    private static final int NO_PATH = -1;
    /**
     * 寻路对应的图实例
     */
    Graph graph;
    /**
     * 记录顶点是否被访问过
     */
    boolean[] visited;
    /**
     * 起点
     */
    int startVertex;
    /**
     * 对应点从哪里访问过来的，路径记录
     * from[i]=a 表示从a能到i
     */
    int[] from;

    public Path(int startVertex, Graph graph) {
        this.graph = graph;

        assert startVertex >= 0 && startVertex < graph.getVertexCnt();
        this.startVertex = startVertex;

        visited = new boolean[graph.getVertexCnt()];
        Arrays.fill(visited, false);
        from = new int[graph.getVertexCnt()];
        Arrays.fill(from, NO_PATH);

        // 深度优先遍历，走起来！
        dfs(startVertex);
    }

    private void dfs(int from) {
        visited[from] = true;
        Iterable<Integer> adjacentVertexes = graph.getAdjacentVertexes(from);
        for (Integer i : adjacentVertexes) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            this.from[i] = from;
            dfs(i);
        }
    }

    /**
     * 判断起点到a点是否有路径
     *
     * @param a 待判断的a点
     */
    boolean hasPath(int a) {
        assert a >= 0 && a < graph.getVertexCnt();
        return visited[a];
    }

    /**
     * 按顺序收集从起点到a点的路径
     *
     * @param a 待判断的a
     */
    List<Integer> collectPath(int a) {
        assert hasPath(a);
        Deque<Integer> stack = new LinkedList<>();
        // a为终点，所以先压栈
        int curr = a;
        while (curr != NO_PATH) {
            stack.push(curr);
            curr = from[curr];
        }

        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    void printPath(int a) {
        collectPath(a).stream().map(v -> v + "->").forEach(System.out::print);
        System.out.println("");
        System.out.println("---");
    }

}
