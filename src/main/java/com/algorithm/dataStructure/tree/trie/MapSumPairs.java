package com.algorithm.dataStructure.tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 * 设计一个 map ，满足以下几点:
 * <p>
 * 字符串表示键，整数表示值
 * 返回具有前缀等于给定字符串的键的值的总和
 * 实现一个 MapSum 类：
 * <p>
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * <p>
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // 返回 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // 返回 5 (apple + app = 3 + 2 = 5)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 * <p>
 * https://leetcode.cn/problems/map-sum-pairs/
 *
 * @author dragonsong  @date 2022/7/7
 */
public class MapSumPairs {

    /*
     * 设：
     * n 为入参字符串长度
     * m 为插入的字符串数量
     */

    static class Trie {
        /*
         * 执行用时：
         * 12 ms
         * , 在所有 Java 提交中击败了
         * 25.64%
         * 的用户
         * 内存消耗：
         * 41.7 MB
         * , 在所有 Java 提交中击败了
         * 7.29%
         * 的用户
         * 通过测试用例：
         * 35 / 35
         */

        /**
         * 特里树根
         * 空间占用 O(n*m)
         */
        Node root;
        /**
         * 记录每个key最新value，方便后续替换
         * 空间占用 O(m)
         */
        Map<String, Integer> kv;

        public Trie() {
            root = new Node();
            kv = new HashMap<>();
        }

        /**
         * 插入时间复杂度：O(n)
         */
        void insert(String key, int val) {
            Node curr = root;
            char[] arr = key.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (!curr.children.containsKey(arr[i])) {
                    curr.children.put(arr[i], new Node());
                }
                // 求和
                curr.children.get(arr[i]).sum += val;
                // 将原来已存在的值删掉
                if (kv.containsKey(key)) {
                    curr.children.get(arr[i]).sum -= kv.get(key);
                }
                curr = curr.children.get(arr[i]);
            }
            kv.put(key, val);
        }

        Node findNodeByPrefix(String prefix) {
            Node curr = root;
            char[] arr = prefix.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (!curr.children.containsKey(arr[i])) {
                    curr.children.put(arr[i], new Node());
                }
                curr = curr.children.get(arr[i]);
            }
            return curr;
        }

        /**
         * sum时间复杂度：O(n)
         */
        int sum(String prefix) {
            Node node = findNodeByPrefix(prefix);
            return node == null ? -1 : node.sum;
        }

        /**
         * 前缀树节点
         */
        class Node {
            /**
             * 上下级
             */
            Map<Character, Node> children;
            /**
             * 前缀求和
             */
            int sum;

            public Node() {
                this.children = new HashMap<>();
                this.sum = 0;
            }
        }
    }

    /**
     * 执行用时：
     * 11 ms
     * , 在所有 Java 提交中击败了
     * 63.95%
     * 的用户
     * 内存消耗：
     * 41.2 MB
     * , 在所有 Java 提交中击败了
     * 64.71%
     * 的用户
     * 通过测试用例：
     * 35 / 35
     * <p>
     * 粗暴查找
     */
    static class BF {
        /**
         * 存每个key对应数值
         * 空间占用 O(m)
         */
        Map<String, Integer> kv;

        public BF() {
            kv = new HashMap<>();
        }

        /**
         * 时间复杂度取决于hashmap.put复杂度，为 O(1)
         */
        void insert(String key, int val) {
            kv.put(key, val);
        }

        /**
         * 时间复杂度取决于 key数量*key长度，为 O(m*n)
         */
        int sum(String prefix) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry : kv.entrySet()) {
                if (entry.getKey().startsWith(prefix)) {
                    sum += entry.getValue();
                }
            }
            return sum;
        }
    }


}
