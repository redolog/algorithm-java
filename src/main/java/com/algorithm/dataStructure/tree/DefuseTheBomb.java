package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/defuse-the-bomb/
 *
 * @author songhuilong  @date 2022/9/5
 */
public class DefuseTheBomb {

    static class PreSum {
        /**
         * 预处理成前缀和，计算区间和时直接用前缀和加减可得，单次求和复杂度 O(1)
         * 整体时间复杂度：O(n)
         * <p>
         * 无额外空间开销，空间复杂度：O(1)
         */
        public int[] decrypt(int[] code, int k) {
            int preSum = 0;
            int n = code.length;
            int[] ans = new int[n];
            if (k == 0) {
                return ans;
            }
            // k负数，取相反数，数组反转
            boolean negativeK = k < 0;
            if (negativeK) {
                k = -k;
                reverse(code);
            }
            for (int i = 0; i < n; i++) {
                preSum += code[i];
                code[i] = preSum;
            }
            for (int i = 0; i < n; i++) {
                if (i + k < n) {
                    ans[i] = code[i + k] - code[i];
                } else {
                    ans[i] = code[n - 1] - code[i] + code[i + k - n];
                }
            }
            if (negativeK) {
                reverse(ans);
            }
            return ans;
        }

        private void reverse(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n / 2; i++) {
                swap(arr, i, n - i - 1);
            }
        }

        private void swap(int[] arr, int aIdx, int bIdx) {
            int tmp = arr[aIdx];
            arr[aIdx] = arr[bIdx];
            arr[bIdx] = tmp;
        }
    }

    static class BF {
        /**
         * 时间复杂度 O(n*k)
         */
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] ans = new int[n];
            if (k == 0) {
                return ans;
            }
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    int sum = 0, cnt = 0, j = i;
                    while (cnt < k) {
                        j = (j + 1) % n;
                        sum += code[j];
                        cnt++;
                    }
                    ans[i] = sum;
                }
                return ans;
            }
            // k<0
            for (int i = 0; i < n; i++) {
                int sum = 0, cnt = 0, j = i;
                while (cnt < -k) {
                    j = (j - 1 + n) % n;
                    sum += code[j];
                    cnt++;
                }
                ans[i] = sum;
            }
            return ans;
        }
    }


}
