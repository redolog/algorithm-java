package com.algorithm.dataStructure.heap;

import com.algorithm.util.ArrayUtils;

/**
 * 大顶堆：
 * 1. 使用数组存储数据；
 * 2. 一颗完全二叉树，除了最后一层其它层都满排列，最后一层靠左排列；
 * 3. 父节点大于等于任一子节点（小顶堆则相反）；
 * <p>
 * [null,7,5,6,4,2,1]
 * <p>
 * 7
 * 5 6
 * 4 2 1
 * <p>
 * 下标：
 * 1
 * 2 3
 * 4 5 6
 *
 * @author dragonsong  @date 2022/5/28
 */
public class MaxHeap {

    /**
     * 使用数组存储数据，为了便于获取父子节点下标，我们从1下标开始存
     */
    int[] elements;
    /**
     * 当前元素数
     */
    int size;
    /**
     * 容量
     */
    int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity + 1];
        this.size = 0;
    }

    /**
     * 观察下标：
     * 1
     * 2 3
     * 4 5 6
     *
     * @param childIdx 子节点下标
     * @return childIdx / 2 即为父节点下标
     */
    public int getParentIdx(int childIdx) {
        return childIdx / 2;
    }

    /**
     * @param parentIdx 父节点下标
     * @return 2 * parentIdx 即为左子节点下标
     */
    public int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx;
    }

    /**
     * @param parentIdx 父节点下标
     * @return 2 * parentIdx+1 即为右子节点下标
     */
    public int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    public boolean insert(int element) {
        if (capacity == size) {
            System.err.println(String.format("MaxHeap已满，capacity==size %d", capacity));
            return false;
        }
        ++size;
        elements[size] = element;
        // 从下往上遍历父子节点，检查是否满足最大堆性质：任意子节点小于等于父节点
        heapify2Up(size);
        return true;
    }

    /**
     * 从下往上遍历父子节点，检查是否满足最大堆性质：任意子节点小于等于父节点
     * 不满足堆性质时，将大元素逐步往上替换
     *
     * @param childIdx 当前子节点下标
     */
    private void heapify2Up(int childIdx) {
        int parentIdx = getParentIdx(childIdx);
        while (parentIdx > 0 && elements[parentIdx] < elements[childIdx]) {
            // 父节点小于子节点时，交换两个节点的值
            ArrayUtils.swap(elements, parentIdx, childIdx);
            childIdx = parentIdx;
            parentIdx = getParentIdx(childIdx);
        }
    }

    /**
     * 移除堆顶最大元素
     * 分析：
     * 1. 如果我们移除最大元素后，数组中第二大元素必然要升到最顶处，可以简单的比较左右节点大小来判断是左还是右侧更大。
     * 如果第二大元素出现在左侧，并且逐步从上至下挪动、填充空缺后，必然会造成左子树有了空缺。
     * <p>
     * 2. 我们可以考虑将数组最小元素（末端）放到堆顶，再依次从上至下堆化，这样不会有空缺。
     */
    public void removeMax() {
        if (size == 0) {
            return;
        }
        int topIdx = 1;
        elements[topIdx] = elements[size];

        --size;

        heapifyToDown(topIdx);
    }

    /**
     * 从上往下堆化，检查父节点值是否大于等于子节点值，如果不满足性质，则替换节点，继续检查
     *
     * @param parentIdx 父节点下标
     */
    private void heapifyToDown(int parentIdx) {
        int leftChildIdx = getLeftChildIdx(parentIdx);
        int rightChildIdx = getRightChildIdx(parentIdx);
        while (leftChildIdx <= size && rightChildIdx <= size) {
            // 满足左右子节点值小于父节点，跳出遍历
            if (elements[parentIdx] >= elements[leftChildIdx] && elements[parentIdx] >= elements[rightChildIdx]) {
                break;
            }

            int biggerIdx = elements[parentIdx] < elements[leftChildIdx] ? leftChildIdx : rightChildIdx;
            ArrayUtils.swap(elements, parentIdx, biggerIdx);
            parentIdx = biggerIdx;
            leftChildIdx = getLeftChildIdx(parentIdx);
            rightChildIdx = getRightChildIdx(parentIdx);
        }
    }

}
