package com.algorithm.dataStructure.array;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 * <p>
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author dragonsong  @date 2022/6/21
 */
public class ExchangeOddEven {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 49.5 MB
     * , 在所有 Java 提交中击败了
     * 11.84%
     * 的用户
     * 通过测试用例：
     * 17 / 17
     */
    public int[] exchange(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (true) {
            while (l < n - 1 && arr[l] % 2 != 0) {
                ++l;
            }
            while (r > 0 && arr[r] % 2 == 0) {
                --r;
            }

            if (l >= r) {
                break;
            }

            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        return arr;
    }
}
