package com.algorithm.dataStructure.array.app;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/subdomain-visit-count/
 *
 * @author DragonSong  @date 2022/10/5
 */
public class SubdomainVisitCount {

    static class TrieSolution {

        static class TrieNode {
            // 当前段对应总访问次数
            int cnt;
            // 子节点
            Map<String, TrieNode> children;

            public TrieNode() {
                children = new HashMap<>();
            }
        }

        /**
         * 使用特里树保存各级域名、计数
         */
        public List<String> subdomainVisits(String[] cpdomains) {
            TrieNode root = new TrieNode();
            // 将域名、计数存入前缀树
            for (String cpdomain : cpdomains) {
                String[] domainArr = cpdomain.split(" ");
                int cnt = Integer.parseInt(domainArr[0]);
                String subDomain = domainArr[1];
                addNode(root, subDomain.split("\\."), cnt);
            }
            // 将前缀树转换为结果形式
            List<String> ans = new LinkedList<>();
            transNode2Ans(root, ans, "");
            return ans;
        }

        private void transNode2Ans(TrieNode curr, List<String> ans, String parentPath) {
            if (curr == null || curr.children == null || curr.children.isEmpty()) {
                return;
            }

            for (Map.Entry<String, TrieNode> entry : curr.children.entrySet()) {
                TrieNode node = entry.getValue();
                String path = parentPath.isEmpty() ? entry.getKey() : entry.getKey() + "." + parentPath;
                ans.add(node.cnt + " " + path);
                transNode2Ans(node, ans, path);
                path = null;
            }
        }

        /**
         * @param parent           前缀树上级节点
         * @param domainSegmentArr 域名每一级的段名，也是我们的前缀树中保存的节点名
         * @param cnt              当前一串域名共同的计数
         */
        private void addNode(TrieNode parent, String[] domainSegmentArr, int cnt) {
            // 域名倒序，com org等顶级域名先加入前缀树
            for (int i = domainSegmentArr.length - 1; i >= 0; i--) {
                String subdomain = domainSegmentArr[i];
                // 如果树中已经有当前节点，只更新计数即可
                if (parent.children.containsKey(subdomain)) {
                    parent.children.get(subdomain).cnt += cnt;
                } else {
                    TrieNode curr = new TrieNode();
                    curr.cnt = cnt;
                    parent.children.put(subdomain, curr);
                }
                parent = parent.children.get(subdomain);
            }
        }
    }

    static class MapSolution {
        public List<String> subdomainVisits(String[] cpdomains) {
            // 保存域名（各个级别）对应访问次数
            Map<String, Integer> domain2Cnt = new HashMap<>();
            for (String cpdomain : cpdomains) {
                String[] domainArr = cpdomain.split(" ");
                int cnt = Integer.parseInt(domainArr[0]);
                String subDomain = domainArr[1];
                domain2Cnt.put(subDomain, domain2Cnt.getOrDefault(subDomain, 0) + cnt);

                // 子域名一直分解到顶级域名
                // 这里需要一直遍历字符串
                while (subDomain.contains(".")) {
                    subDomain = subDomain.substring(subDomain.indexOf(".") + 1);
                    domain2Cnt.put(subDomain, domain2Cnt.getOrDefault(subDomain, 0) + cnt);
                }
            }
            return domain2Cnt.entrySet().stream()
                    .map(entry -> entry.getValue() + " " + entry.getKey())
                    .collect(Collectors.toList());
        }
    }


}
