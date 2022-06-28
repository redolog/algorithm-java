package com.algorithm.dataStructure.skiplist;


import static com.algorithm.dataStructure.skiplist.SkipListLevelUtils.MAX_LEVEL;

/**
 * 复杂度分析：
 * 生成随机level时，默认使用0.5的下一层生成概率
 * <p>
 * <p>****************************************************************
 * 空间：
 * 此时我们的层数分布遵循：最高层维护两个数据，每降低一层 数量/2
 * 层高设为h，数据量n：
 * - 第一层 n/2
 * - 第二层 n/2^2
 * - 第h层 n/(2^h)=2
 * <p>
 * 所以 h=logn
 * <p>
 * n/2+n/4+n/8…+8+4+2=n-2 为各层节点的数量和
 * 空间复杂度 O(n)，索引层为额外的空间
 * <p>
 * <p>****************************************************************
 * 时间：
 * 写入、读取复杂度一致，均取决于每层跳转的节点数 以及 跳表高度。
 * <p>
 * 读取过程：
 * 从最上层一直往下寻找，最顶层只有 head/tail 元素，顶层最多跳转到tail，大部分情况是从head往下跳
 * 到了倒数第二层，上一步已经跳过了一半元素，根据同样的步骤，查找元素时，要么不跳往下，要么跳一次（跳两次就到了上一次判断过的边界）
 * 因此，每一层跳跃，最多经过三个节点
 * <p>
 * 此时写入、读取的复杂度为 O(3*log2n)，去掉常数阶、低阶，复杂度为 O(logn)
 * 根据大O算法的衡量标准，跳表的时间复杂度与二分一致
 *
 * @author dragonsong  @date 2022/6/28
 */
public class SimpleSkipList {

    /**
     * 链表入口，最左上的头
     */
    Node head;
    /**
     * 当前生成的最高层
     */
    int maxLevel;
    /**
     * 跳表元素数
     */
    int size;

    public SimpleSkipList() {
        head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE, MAX_LEVEL);
        maxLevel = 0;
        size = 0;
    }

    /**
     * 根据key匹配节点：
     * 从最上层索引，匹配next，当next>key时，到下一层寻找
     *
     * @param key 待匹配的key
     * @return 匹配到的节点，可null
     */
    Node get(int key) {
        Node curr = head;
        // 从上往下
        for (int level = maxLevel - 1; level >= 0; level--) {
            while (curr != null && curr.next[level] != null && curr.next[level].key < key) {
                // 当前值小于key，一直往后挪动
                curr = curr.next[level];
            }
        }
        // 移动到了最下层
        if (curr == null || curr.next[0] == null || curr.next[0].key != key) {
            return null;
        }
        return curr.next[0];
    }

    /**
     * 写入k-v键值对
     *
     * @param key 根据key排序，查找插入位置
     * @param val 同时记录值
     */
    void put(int key, int val) {
        int level = SkipListLevelUtils.genRandomLevel();
        maxLevel = Math.max(level, maxLevel);
        Node newNode = new Node(key, val, level);

        // 存放newNode每层的前序节点
        Node[] prev = new Node[level];
        Node curr = head;
        // 填充待插入位置的前序节点
        for (int i = level - 1; i >= 0; i--) {
            // 从上往下找newNode新插入位置
            while (curr != null && curr.next != null && curr.next[i] != null && curr.next[i].key < key) {
                curr = curr.next[i];
            }
            prev[i] = curr;
        }

        // 连接 前序->newNode->next
        for (int i = 0; i < prev.length; i++) {
            newNode.next[i] = prev[i].next[i];
            prev[i].next[i] = newNode;
        }
        ++size;
    }

    /**
     * 逐层打印跳表结构
     */
    void print() {
        System.out.println("最大层数：" + maxLevel);

        Node[] headNext = head.next;

        for (int i = maxLevel - 1; i >= 0; i--) {
            System.out.println("层数：" + i);

            Node curr = headNext[i];
            while (curr != null) {
                System.out.print(curr + "-->");
                curr = curr.next[i];
            }
            System.out.println();
        }
    }

    static class Node {
        /**
         * 表示节点key
         */
        int key;
        /**
         * 表示节点值
         */
        int val;
        /**
         * 当前节点各层的next
         */
        Node[] next;

        public Node() {
        }

        public Node(int key, int val, int level) {
            this.key = key;
            this.val = val;
            this.next = new Node[level];
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", val=" + val + '}';
        }
    }
}
