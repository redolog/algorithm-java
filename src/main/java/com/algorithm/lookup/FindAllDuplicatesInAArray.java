package com.algorithm.lookup;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 *
 * @author dragonsong  @date 2022/8/23
 */
public class FindAllDuplicatesInAArray {

    /**
     * 当前值对应下标，访问过后，我们将其设置为相反数，表示已经被访问
     * 下次碰到重复值，发现对应下标值已经是负数，将其相反数塞进ans
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public List<Integer> findDuplicates3(int[] nums) {
        // 访问过的数字，在对应下标处标记为负数相反数
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curr = Math.abs(nums[i]);
            if (nums[curr - 1] < 0) {
                ans.add(curr);
            } else {
                nums[curr - 1] = -nums[curr - 1];
            }
        }
        return ans;
    }

    /**
     * 对解法1的改进，代码更简洁
     * 当前位置值不在对应位置上时，我们就将值替换过去，同时注意，while判断处使用了 nums[i] 取值，因此如果在block内更新替换，会导致引用问题
     * 替换完之后，我们取不等的值即可
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != nums[i] - 1) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    /**
     * 与 FindRepeatNumber 做法一致
     * O(n) 时间复杂度
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // i指向前序已经归位的下一个下标
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 != nums[i] && nums[i] != -1) {
                if (nums[i] - 1 >= 0 && nums[nums[i] - 1] == nums[i]) {
                    // -1表示是重复值，还原使用 i+1 即可
                    nums[nums[i] - 1] = -1;
                    // 0表示是空位，可以插入新值
                    nums[i] = 0;
                    break;
                }
                if (nums[i] == 0) {
                    // 当前值为空位，直接到下一个下标处理
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
            // i位置的元素已经归位了
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != -1) {
                continue;
            }
            ans.add(i + 1);

        }

        return ans;
    }

    public void swap(int[] nums, int i1, int i2) {
        if (i1 < 0 || i1 >= nums.length || i2 < 0 || i2 >= nums.length) {
            return;
        }
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
