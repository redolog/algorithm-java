package com.algorithm.dataStructure.tree;

/**
 * https://leetcode.cn/problems/defuse-the-bomb/
 *
 * @author songhuilong  @date 2022/9/5
 */
public class DefuseTheBomb {

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
