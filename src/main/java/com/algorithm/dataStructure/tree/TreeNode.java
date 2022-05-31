package com.algorithm.dataStructure.tree;

import com.algorithm.util.ArrayUtils;

import java.util.Objects;

/**
 * 二叉树节点
 *
 * @author dragonsong  @date 2022/5/30
 */
public class TreeNode {

    public static final int INVALID_VAL = Integer.MIN_VALUE;

    /**
     * 当前节点值
     * 我们定义 val==-1 为异常值
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

    public static boolean invalidVal(int val) {
        return val == INVALID_VAL;
    }

    public static boolean validVal(int val) {
        return val != INVALID_VAL;
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
     * 构建普通二叉树
     */
    public static TreeNode buildWithArr(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return null;
        }
        return buildCompleteWithArrIdx(arr,0);
    }

    private static TreeNode buildCompleteWithArrIdx(int[] array, int parentIdx) {
        TreeNode root = null;
        if (parentIdx < array.length) {
            root = new TreeNode(array[parentIdx]);
            root.left = buildCompleteWithArrIdx(array, getCompleteLeftChildIdx(parentIdx));
            root.right = buildCompleteWithArrIdx(array, getCompleteRightChildIdx(parentIdx));
        }
        return root;

    }

    /**
     * <p>
     * 构建完全二叉树
     */
    public static TreeNode buildCompleteWithArr(int[] arr) {
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
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (null == left ? "null" : left.val) +
                ", right=" + (null == right ? "null" : right.val) +
                '}';
    }
}
