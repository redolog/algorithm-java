package com.algorithm.dataStructure.array.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/design-authentication-manager/
 *
 * @author songhuilong001  @date 2023/2/9
 */
public class AuthenticationManager {

    private int timeToLive;

    // 链表首尾
    NodeEntry head, tail;
    private Map<String, NodeEntry> tokenId2Node;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenId2Node = new HashMap<>();
        this.head = new NodeEntry();
        this.tail = new NodeEntry();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * O(1)
     */
    public void generate(String tokenId, int currentTime) {
        // 链表原位置原地删除，链表尾部添加新元素
        removeNode(tokenId2Node.get(tokenId));
        insertNode(new NodeEntry(tokenId, currentTime));
    }

    private void insertNode(NodeEntry newNode) {
        if (newNode == null) {
            return;
        }
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;

        tokenId2Node.put(newNode.tokenId, newNode);
    }

    private void removeNode(NodeEntry oldNode) {
        if (oldNode == null) {
            return;
        }
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
        tokenId2Node.remove(oldNode.tokenId);
    }

    public void expire(NodeEntry curr) {
        while (curr != null && !curr.equals(head)) {
            removeNode(curr);
            curr = curr.prev;
        }
    }

    /**
     * 对存活entry续期；
     * 清理过期entry；
     * 不存在的entry直接忽略；
     */
    public void renew(String tokenId, int currentTime) {
        NodeEntry oldNode = tokenId2Node.get(tokenId);
        if (oldNode == null) {
            // 不存在，不管了
            return;
        }
        if (oldNode.insertTime + timeToLive > currentTime) {
            // 依旧存活，续期
            removeNode(oldNode);
            insertNode(new NodeEntry(tokenId, currentTime));
        } else {
            // 过期，删除entry，同时将时间序列递增的前序entry都删除
            expire(oldNode);
        }
    }

    /**
     * O(n)
     * 同时清理过期entry
     */
    public int countUnexpiredTokens(int currentTime) {
        NodeEntry curr = head.next;
        while (curr != null && !curr.equals(tail) && curr.insertTime + timeToLive <= currentTime) {
            expire(curr);
            curr = curr.next;
        }
        return tokenId2Node.size();
    }

    static class NodeEntry {
        int insertTime;
        String tokenId;
        // 链表前序、后继指针
        NodeEntry prev, next;

        public NodeEntry(String tokenId, int insertTime) {
            this.insertTime = insertTime;
            this.tokenId = tokenId;
        }

        public NodeEntry() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NodeEntry)) return false;
            NodeEntry nodeEntry = (NodeEntry) o;
            if (insertTime != nodeEntry.insertTime) return false;
            return Objects.equals(tokenId, nodeEntry.tokenId);
        }

        @Override
        public int hashCode() {
            int result = insertTime;
            result = 31 * result + (tokenId != null ? tokenId.hashCode() : 0);
            return result;
        }
    }
}
