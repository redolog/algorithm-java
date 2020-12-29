package com.algorithm.dataStructure.array;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 * @author DragonSong  @date 2020/12/29
 * @link {https://leetcode-cn.com/problems/remove-element/}
 */

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        return bruteForce(nums, val);
    }

    private int bruteForce(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                // 发现目标val
                for (int j = i + 1; j < len; j++) {
                    // val后的数组元素整体前移一位，抛弃val在nums的存储
                    nums[j - 1] = nums[j];
                }
                // 前移后数组容量-1
                i--;
                len--;
            }
        }
        return len;
    }

    /**
     * 本质上是要查找不等于val的值，从前往后组成一个数组
     */
    private int twoCursor(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 相同元素较少时，数组复制操作可以减少，优化计算效率
     * 通过while循环，进行快慢指针的两次循环（接续上次停留位置）
     */
    private int twoCursorWithLessSameElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 找到目标值就调换left、right
            if (nums[left] == val) {
                // 当前值切换为当前数组最后一个元素
                nums[left] = nums[right];
                // 下一轮的最后的下标-1，left不变，while循环下一轮还是判断当前位置的新值
                right--;
            } else {
                left++;
            }
        }

        // 新数组长度
        return left;
    }

}
