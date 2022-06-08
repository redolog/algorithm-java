package com.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * <p>
 * https://leetcode.cn/problems/permutations/
 *
 * @author dragonsong  @date 2022/6/6
 */
public class Permutations {

    /*
     * 复杂度分析：
     *
     * 时间复杂度：
     * 回溯算法时间复杂度复杂度由递归树节点数*节点上的操作决定。
     * 我们假设排列为 `A(n,m)` 表示从n个数中选m个为一组排列。等同于`P(n,m)`。
     * 1. 非叶子节点数：
     *  - 第一层：A(n,1)，从n个数中选一个数；
     *  - 第二层：A(n,2)，从n个数中选两个数；
     *  - ...
     *  - 倒数第一层：A(n,m-1)，从n个数中选m-1 个数；
     *  - 非叶子节点总数为上述和，代入排列公式：
     *      sum= n!/(n-1)! + n!/(n-2)! + ... + n!/(n-m+1)!
     *          = n!*((1/(n-1)!) + (1/(n-2)!) +...+ (1/(n-m+1)!) )
     *      其中 n==m ，代入公式，得
     *      sum= n!*((1/(n-1)!) + (1/(n-2)!) +...+ 1)
     *          <= n!*((1/(2^(n-1))) + ... + (1/4) + (1/2) +1)
     *          <= n!*2*((2^n-1)/2^n)
     *          < 2n!
     * 2. 非叶子节点上的操作
     *  - 在每个非叶子节点上我们都通过dfs()方法去遍历nums，也就是一个节点上我们都得循环查找未使用的位置。这个操作代价为 n（需要给pathQueue装满数据，也就是size==n）。
     * 3. 综上，回溯非叶子节点的复杂度为 O(n*2n!)
     *
     * 4. 叶子节点数：n!
     * 5. 叶子节点上的操作：ansList.add(new ArrayList<>(pathQueue)); 拷贝n个数据的数组，代价为n；
     * 6. 综上回溯叶子节点的复杂度为 O(n*n!)
     *
     * 7. 综上，整个Permutations回溯的时间复杂度为 O(n*n!)。
     *
     *
     * 空间复杂度：
     * 全排列一共n!种排列形式，其中每一种排列中，我们使用siz==n的容器空间开销，因此空间复杂度为 O(n*n!)
     *
     */

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 81.01%
     * 的用户
     * 内存消耗：
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 84.75%
     * 的用户
     * 通过测试用例：
     * 26 / 26
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ansList;
        }
        int n = nums.length;
        // 排列问题，是典型的树形遍历问题，我们使用深度有限遍历的方式走访每个可能的分支
        // 使用一个 path 容器，存放当前分支下的数据，回溯即回撤时从末尾回退数据，使用一个栈结构保存
        Deque<Integer> pathQueue = new LinkedList<>();
        // 同时，我们需要记录每个位置元素使用的状态，为boolean类型数组，同时需要回溯时回退状态
        boolean[] usedArr = new boolean[n];

        // 深度优先遍历，递归函数
        dfs(nums, n, pathQueue, usedArr, ansList);

        return ansList;
    }

    private void dfs(int[] nums, int n, Deque<Integer> pathQueue, boolean[] usedArr, List<List<Integer>> ansList) {
        if (pathQueue.size() == n) {
            // 递归边界：当分支数据记录到n的数据规模时，递归停止，同时，将记录好的分支数据添加到ansList中
            // 如果直接添加pathStack，添加的是引用副本，递归调用中容器内数据会变动，所以我们拷贝一份数据副本
            ansList.add(new ArrayList<>(pathQueue));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (usedArr[i]) {
                // 在当前树路径上该节点已被选
                continue;
            }

            usedArr[i] = true;
            pathQueue.offerLast(nums[i]);
            dfs(nums, n, pathQueue, usedArr, ansList);
            // 回溯：回退之前的状态
            usedArr[i] = false;
            pathQueue.pollLast();
        }
    }

}
