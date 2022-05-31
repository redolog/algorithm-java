package com.algorithm.dataStructure.tree;

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
 * <p>
 * 数据结构的堆是一种逻辑结构。编程语言中的堆往往指一块内存区域、池。
 *
 * @author dragonsong  @date 2022/5/28
 */
public class MaxHeap {

    /**
     * 使用数组存储数据，为了便于获取父子节点下标，我们从1下标开始存
     */
    public int[] elements;
    /**
     * 当前元素数
     */
    public int size;
    /**
     * 容量
     */
    public int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
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
    public static int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    /**
     * @param parentIdx 父节点下标
     * @return 2 * parentIdx 即为左子节点下标
     */
    public static int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    /**
     * @param parentIdx 父节点下标
     * @return 2 * parentIdx+1 即为右子节点下标
     */
    public static int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    public boolean insert(int element) {
        if (capacity == size) {
            System.err.println(String.format("MaxHeap已满，capacity==size %d", capacity));
            return false;
        }
        elements[size] = element;
        // 从下往上遍历父子节点，检查是否满足最大堆性质：任意子节点小于等于父节点
        heapify2Up(size);
        ++size;
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
        while (parentIdx >= 0 && childIdx < elements.length && elements[parentIdx] < elements[childIdx]) {
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
        while (leftChildIdx <= size || rightChildIdx <= size) {
            // 满足左右子节点值小于父节点，跳出遍历
            if (elements[parentIdx] >= elements[leftChildIdx] && (rightChildIdx <= size && elements[parentIdx] >= elements[rightChildIdx])) {
                break;
            }

            int biggerIdx = elements[parentIdx] < elements[leftChildIdx] ? leftChildIdx : rightChildIdx;
            ArrayUtils.swap(elements, parentIdx, biggerIdx);
            parentIdx = biggerIdx;
            leftChildIdx = getLeftChildIdx(parentIdx);
            rightChildIdx = getRightChildIdx(parentIdx);
        }
    }

    // 建堆：对数组堆化，形成完全二叉树逻辑结构

    /**
     * 插入式建堆
     * insert本质上是从下往上heapify堆合理化，即子节点插入，与其父节点对比
     *
     * @param arr 数据源
     */
    public void buildHeap2Up(int[] arr) {
        for (int element : arr) {
            this.insert(element);
        }
    }

    /**
     * 从数组中间下标开始处理，即倒数第二层倒序遍历（从右向左）
     *
     * @param arr 原数组
     */
    public static void buildHeap2Down(int[] arr) {
        buildHeap2Down(arr, arr.length - 1);
    }

    public static void buildHeap2Down(int[] arr, int lastChildIdx) {
        if (ArrayUtils.isEmpty(arr)) {
            return;
        }
        int parentIdx = getParentIdx(lastChildIdx);
        for (; parentIdx >= 0; parentIdx--) {
            // 控制树的倒数第二层遍历。父节点对比左右子节点，即从上往下堆化
            parentIdx = heapify(arr, lastChildIdx, parentIdx);
        }
    }

    /**
     * 堆化：
     * 每一轮堆化操作复杂度与节点高成正比，复杂度 O(logn)
     */
    public static int heapify(int[] arr, int lastChildIdx, int parentIdx) {
        while (true) {
            // 判断当前父子节点值大小关系，同时向下遍历子树
            int biggerIdx = parentIdx;
            int leftChildIdx = getLeftChildIdx(parentIdx);
            int rightChildIdx = getRightChildIdx(parentIdx);
            if (rightChildIdx <= lastChildIdx && arr[rightChildIdx] > arr[parentIdx]) {
                biggerIdx = rightChildIdx;
            }
            if (leftChildIdx <= lastChildIdx && arr[leftChildIdx] > arr[parentIdx]) {
                biggerIdx = leftChildIdx;
            }
            if (biggerIdx == parentIdx) {
                // 当前父节点大于左右节点，继续遍历树
                break;
            }
            ArrayUtils.swap(arr, biggerIdx, parentIdx);

            // parentIdx 与其子节点交换后，需保证 parentIdx下任意子树都满足堆性质，往下遍历
            parentIdx = biggerIdx;
        }
        return parentIdx;
    }

}
