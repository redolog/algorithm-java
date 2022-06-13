package com.algorithm.dataStructure.tree;

import com.algorithm.util.ArrayUtils;

/**
 * 索引堆：
 * 在原先最大堆的基础上，增加一层id映射：插入数据时维护数据项->下标关系
 * 堆性质维护在id上操作，不挪动数据项在数组中的位置（大数据、大对象时挪动开销过大）
 * <p>
 * 优点：
 * 1. 交换索引下标效率高；
 * 2. 可以方便操作数据项对应优先级（顺序）；
 *
 * @author dragonsong  @date 2022/6/13
 */
public class IndexMaxHeap {

    /**
     * 使用数组存储数据，为了便于获取父子节点下标，我们从1下标开始存
     */
    public int[] elements;
    /**
     * id下标映射
     */
    public int[] indexes;

    /**
     * 当前元素数
     */
    public int size;
    /**
     * 容量
     */
    public int capacity;

    public IndexMaxHeap(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
        this.indexes = new int[capacity];
        this.size = 0;
    }

    public static int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    public static int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    public static int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    public boolean insert(int element, int idx) {
        if (capacity == size) {
            System.err.printf("MaxHeap已满，capacity==size %d%n", capacity);
            return false;
        }
        // idx->element
        elements[idx] = element;
        indexes[size] = idx;
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
        while (parentIdx >= 0 && childIdx < elements.length
                // 通过indexes定位idx对应indexes上的位置，此位置对应数据项下标
                && elements[indexes[parentIdx]] < elements[indexes[childIdx]]) {
            // 父节点小于子节点时，交换两个节点的值
            ArrayUtils.swap(indexes, parentIdx, childIdx);
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
        indexes[topIdx] = indexes[size];

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
            if (elements[indexes[parentIdx]] >= elements[indexes[leftChildIdx]] && (rightChildIdx <= size && elements[indexes[parentIdx]] >= elements[indexes[rightChildIdx]])) {
                break;
            }

            int biggerIdx = elements[indexes[parentIdx]] < elements[indexes[leftChildIdx]] ? leftChildIdx : rightChildIdx;
            ArrayUtils.swap(indexes, parentIdx, biggerIdx);
            parentIdx = biggerIdx;
            leftChildIdx = getLeftChildIdx(parentIdx);
            rightChildIdx = getRightChildIdx(parentIdx);
        }
    }

    /**
     * 按插入下标获取元素
     *
     * @param idx 插入下标
     * @return 元素值
     */
    public int getElementByIdx(int idx) {
        return elements[idx];
    }

    public int getMaxIdx() {
        if (size <= 0) {
            System.err.println("当前最大堆空");
            return -1;
        }
        int maxIdx = indexes[0];

        ArrayUtils.swap(indexes, 0, size);
        --size;
        heapifyToDown(0);

        return maxIdx;
    }

}
