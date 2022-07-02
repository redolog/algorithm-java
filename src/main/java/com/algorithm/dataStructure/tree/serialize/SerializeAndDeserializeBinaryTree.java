package com.algorithm.dataStructure.tree.serialize;


import com.algorithm.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 *
 * @author dragonsong  @date 2022/7/2
 */
public class SerializeAndDeserializeBinaryTree {

    /*
     * 执行用时：
     * 34 ms
     * , 在所有 Java 提交中击败了
     * 23.50%
     * 的用户
     * 内存消耗：
     * 43.8 MB
     * , 在所有 Java 提交中击败了
     * 30.70%
     * 的用户
     * 通过测试用例：
     * 52 / 52
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node == null ? null : node.val);
            if (node != null) {
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 2) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] nodeStrArr = data.split(", ");
        TreeNode root = new TreeNode(Integer.parseInt(nodeStrArr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode curr;
        for (int i = 1; i < nodeStrArr.length; ) {
            curr = q.poll();
            if (curr == null) {
                break;
            }
            Integer leftVal = "null".equals(nodeStrArr[i]) ? null : Integer.valueOf(nodeStrArr[i]);
            curr.left = leftVal == null ? null : new TreeNode(leftVal);
            if (curr.left != null) {
                q.offer(curr.left);
            }
            ++i;
            if (i < nodeStrArr.length) {
                Integer rightVal = "null".equals(nodeStrArr[i]) ? null : Integer.valueOf(nodeStrArr[i]);
                curr.right = rightVal == null ? null : new TreeNode(rightVal);
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                ++i;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
