package com.algorithm.dataStructure.tree;

import com.algorithm.util.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 二叉树节点
 *
 * @author dragonsong  @date 2022/5/30
 */
public class TreeNode {

    public static final int INVALID_VAL = Integer.MIN_VALUE;

    /**
     * 当前节点值
     * 我们定义 val==MIN_VALUE 为异常值
     */
    public int val;
    /**
     * 左子节点
     */
    public TreeNode left;
    /**
     * 右子节点
     */
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public static boolean invalidVal(Integer val) {
        return val == null || val == INVALID_VAL;
    }

    public static boolean validVal(Integer val) {
        return val != null && val != INVALID_VAL;
    }

    /**
     * 完全二叉树获取父节点下标
     *
     * @param childIdx 子节点下标
     * @return childIdx-1 / 2 即为父节点下标
     */
    public static int getCompleteParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    /**
     * 完全二叉树获取左子节点下标
     *
     * @param parentIdx 父节点下标
     * @return 2 * parentIdx +1 即为左子节点下标
     */
    public static int getCompleteLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    /**
     * 完全二叉树获取右子节点下标
     *
     * @param parentIdx 父节点下标
     * @return 2 * parentIdx+2 即为右子节点下标
     */
    public static int getCompleteRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }


    /**
     * 1,2,-1,3,-1,4,-1,5
     * 0,1,2 ,3 ,4,5 ,6,7
     * <p>
     * 按层构建普通二叉树
     */
    public static TreeNode buildAnyWithArr(Integer[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return new TreeNode();
        }

        // 存原数组数字信息
        Queue<Integer> arrQueue = new LinkedList<>(Arrays.asList(arr));
        // 存构建节点信息
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        Integer rootNum = arrQueue.poll();
        if (rootNum == null) {
            return new TreeNode();
        }
        TreeNode root = new TreeNode(rootNum);
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            // 从 nodeQueue 拿出当前待处理节点
            TreeNode node = nodeQueue.poll();
            if (node == null) {
                // 空节点直接跳过
                continue;
            }
            // 从原数组拿出上述节点对应的子节点，入队 nodeQueue 待下次执行
            Integer leftNum = arrQueue.poll();
            nodeQueue.offer(node.left = leftNum == null ? null : new TreeNode(leftNum));

            Integer rightNum = arrQueue.poll();
            nodeQueue.offer(node.right = rightNum == null ? null : new TreeNode(rightNum));
        }
        return root;
    }

    private static TreeNode buildCompleteWithArrIdx(Integer[] array, int parentIdx) {
        TreeNode parent = null;
        if (parentIdx < array.length) {
            if (invalidVal(array[parentIdx])) {
                return null;
            }
            parent = new TreeNode(array[parentIdx]);
            parent.left = buildCompleteWithArrIdx(array, getCompleteLeftChildIdx(parentIdx));
            parent.right = buildCompleteWithArrIdx(array, getCompleteRightChildIdx(parentIdx));
        }
        return parent;

    }

    /**
     * <p>
     * 构建完全二叉树
     */
    public static TreeNode buildCompleteWithArr(Integer[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return null;
        }
        int n = arr.length;
        int lastChildIdx = n - 1;
        TreeNode[] nodeArr = new TreeNode[n];
        for (int parentIdx = 0; parentIdx <= getCompleteParentIdx(lastChildIdx); parentIdx++) {
            if (invalidVal(arr[parentIdx])) {
                continue;
            }

            nodeArr[parentIdx] = nodeArr[parentIdx] == null ? new TreeNode(arr[parentIdx]) : nodeArr[parentIdx];
            int leftChildIdx = getCompleteLeftChildIdx(parentIdx);
            if (leftChildIdx < n) {
                if (nodeArr[leftChildIdx] == null && validVal(arr[leftChildIdx])) {
                    nodeArr[leftChildIdx] = new TreeNode(arr[leftChildIdx]);
                    nodeArr[parentIdx].left = nodeArr[leftChildIdx];
                }
            }
            int rightChildIdx = getCompleteRightChildIdx(parentIdx);
            if (rightChildIdx < n) {
                if (nodeArr[rightChildIdx] == null && validVal(arr[rightChildIdx])) {
                    nodeArr[rightChildIdx] = new TreeNode(arr[rightChildIdx]);
                    nodeArr[parentIdx].right = nodeArr[rightChildIdx];
                }
            }
        }
        return nodeArr[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TreeNode)) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && ((left == null && treeNode.left == null) || (left != null && left.val == treeNode.left.val)) && ((right == null && treeNode.right == null) || (right != null && right.val == treeNode.right.val));
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + ", left=" + (null == left ? "null" : left.val) + ", right=" + (null == right ? "null" : right.val) + '}';
    }
}
