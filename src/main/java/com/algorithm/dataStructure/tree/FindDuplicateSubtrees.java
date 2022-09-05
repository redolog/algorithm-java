package com.algorithm.dataStructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 * <p>
 * https://leetcode.cn/problems/find-duplicate-subtrees/
 *
 * @author songhuilong  @date 2022/9/5
 */
public class FindDuplicateSubtrees {

    List<TreeNode> ans;

    /**
     * 记录每个节点路径出现的次数，仅当第二次出现时加入到ans
     */
    Map<String, Integer> path2Cnt;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        path2Cnt = new HashMap<>();

        dfs(root);

        return ans;
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        String path = node.val + "_" + dfs(node.left) + "_" + dfs(node.right);
        path2Cnt.put(path, path2Cnt.getOrDefault(path, 0) + 1);
        if (path2Cnt.getOrDefault(path, 0) == 2) {
            // 仅仅第二次添加时进入ans，相同path只添加一次
            ans.add(node);
        }
        return path;
    }
}
