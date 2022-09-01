package com.algorithm.lookup;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * @author dragonsong  @date 2022/9/1
 */
public class FinalPricesWithASpecialDiscountInAShop {

    static class BF {
        /**
         * 暴力方式，循环内遍历查找
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(1)
         */
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int j = i + 1;
                for (; j < n; j++) {
                    if (prices[j] <= prices[i]) {
                        break;
                    }
                }
                ans[i] = j == n ? prices[i] : prices[i] - prices[j];
            }

            return ans;
        }
    }

    static class MonotonicDecreasingStack {
        /**
         * 维护一个单调递增栈，倒序遍历prices数组，栈中只维护比当前元素更小的元素
         * 每个元素出入栈一次，时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] ans = new int[n];
            Deque<Integer> stk = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                // 当前元素如果比栈顶更小，则出栈
                while (!stk.isEmpty() && stk.peek() > prices[i]) {
                    stk.pop();
                }
                // 栈空，说明数组后序没有比当前元素更小的值；
                // 栈有值，说明后序有比当前元素更小的元素，并且栈顶小元素下标距离当前位置最近；
                ans[i] = stk.isEmpty() ? prices[i] : prices[i] - stk.peek();
                stk.push(prices[i]);
            }

            return ans;
        }
    }

}
