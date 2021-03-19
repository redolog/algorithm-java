package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
//        Node root = new Node();
//
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (queue.peek() != null) {
//            Node n = queue.poll();
//            System.out.println(n.value);
//            if (n.left != null) {
//                queue.offer(n.left);
//            }
//            if (n.right != null) {
//                queue.offer(n.right);
//            }
//        }

        // telepresence
        // ktctl

        // 设：有一List，每一个为节点：
        //    节点包含：编号（同索引值）
        //    父节点编号
        //    字节点列表（未知）
        //    节点值
        //求： 1 字节点列表
        //    2. 按深度优先打印节点值
        List<Node> l = new ArrayList<>();
        Node root = new Node();
        root.id = 0;
        root.parentId = 0;
        l.add(root);

        Map<Integer, List<Integer>> id2ChildrenIds = new HashMap<>();
        Map<Integer, Node> id2Node = new HashMap<>();
        for (Node node : l) {
            id2Node.put(node.id, node);
            int parentId = node.parentId;
            id2ChildrenIds.putIfAbsent(parentId, new ArrayList<>());
            List<Integer> childrenIds = id2ChildrenIds.get(parentId);
            childrenIds.add(node.id);
        }
        System.out.println(root.value);
        recurse(id2Node, root);
    }

    private static void recurse(Map<Integer, Node> id2Node, Node node) {
        String s = "";

        for (Integer id : node.childrenIds) {
            Node child = id2Node.get(id);
            System.out.println(child.value);
            List<Integer> childrenIds = child.childrenIds;
            if (childrenIds != null && childrenIds.size() > 0) {
                recurse(id2Node, child);
            }
        }
    }
}

class Node {
    //    Node left;
//    Node right;
//    int value;
    int id;
    int parentId;
    List<Integer> childrenIds;
    int value;
}
