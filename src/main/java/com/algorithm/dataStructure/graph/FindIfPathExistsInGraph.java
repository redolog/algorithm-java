package com.algorithm.dataStructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/find-if-path-exists-in-graph/
 *
 * @author songhuilong  @date 2022/12/19
 */
public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        boolean[] visited = new boolean[n];
        List<Integer>[] adjacentList = new List[n];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (adjacentList[a] == null) {
                adjacentList[a] = new ArrayList<>();
            }
            if (adjacentList[b] == null) {
                adjacentList[b] = new ArrayList<>();
            }
            adjacentList[a].add(b);
            adjacentList[b].add(a);
        }
        visited[source] = true;

        Queue<Integer> vertexQ = new ArrayDeque<>();
        vertexQ.offer(source);

        while (!vertexQ.isEmpty()) {
            Integer curr = vertexQ.poll();
            for (Integer next : adjacentList[curr]) {
                if (next == destination) {
                    return true;
                }
                if (visited[next]) {
                    continue;
                }
                vertexQ.offer(next);
                visited[next] = true;
            }
        }
        return false;
    }
}
