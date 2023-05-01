package com.algorithm.dataStructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/time-needed-to-inform-all-employees/
 *
 * @author songhuilong001  @date 2023/5/1
 */
public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> parent2Children = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int managerI = manager[i];
            List<Integer> children = parent2Children.getOrDefault(managerI, new ArrayList<>());
            children.add(i);
            parent2Children.put(managerI, children);
        }
        return dfs(parent2Children, headId, informTime);
    }

    private int dfs(Map<Integer, List<Integer>> parent2Children, int parentId, int[] informTime) {
        if (!parent2Children.containsKey(parentId)) {
            return 0;
        }
        List<Integer> children = parent2Children.get(parentId);
        int pathMax = 0;
        for (Integer childId : children) {
            pathMax = Math.max(pathMax, dfs(parent2Children, childId, informTime));
        }
        return pathMax + informTime[parentId];
    }
}
