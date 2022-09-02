package com.algorithm.decimal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/add-to-array-form-of-integer/
 *
 * @author dragonsong  @date 2022/9/2
 */
public class AddToArrayFormOfInteger {

    /**
     * 诸位处理，直接将所有数位加和的方式不行，因为arr.len可能很长，超出了long值的范围
     * 因此我们从低位逐位叠加，同时更新k在每个位的增量
     * <p>
     * 时间复杂度：O(max(arr.len,logk))
     * 空间复杂度：O(1)
     */
    public List<Integer> addToArrayForm(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            int sum = curr + k;
            deque.addFirst(sum % 10);
            k = sum / 10;
        }
        // 逐位添加k余下的值
        while (k > 0) {
            deque.addFirst(k % 10);
            k /= 10;
        }

        return new ArrayList(deque);
    }
}
