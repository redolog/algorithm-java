package com.algorithm.string;

/**
 * https://leetcode.cn/problems/reverse-string-ii/
 *
 * @author songhuilong001  @date 2022/11/28
 */
public class ReverseStringII {

    static class CharArrSolution {
        public String reverseStr(String s, int k) {
            char[] arr = s.toCharArray();
            int n = s.length();
            for (int i = 0; i < n; i += 2 * k) {
                // 双指针双向奔赴
                int l = i,
                        // 剩下不到k个时，右边界最右到n-1
                        r = Math.min(n - 1, l + k - 1);
                while (l < r) {
                    char lTmp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = lTmp;
                    l++;
                    r--;
                }
            }
            return String.valueOf(arr);
        }
    }

    static class BuilderSolution {
        public String reverseStr(String s, int k) {
            int n = s.length();
            StringBuilder builder = new StringBuilder();
            if (n < k) {
                reverse(s, 0, n - 1, builder);
                return builder.toString();
            }
            int i = 2 * k - 1;
            if (i >= n) {
                reverse(s, 0, k - 1, builder);
                append(s, k, n - 1, builder);
                return builder.toString();
            }
            for (; i < n; i += 2 * k) {
                reverse(s, i - 2 * k + 1, i - k, builder);
                append(s, i - k + 1, i, builder);
                int leftCnt = n - i - 1;
                if (leftCnt < k) {
                    reverse(s, i + 1, n - 1, builder);
                    break;
                }
                if (i + 2 * k >= n) {
                    reverse(s, i + 1, i + k, builder);
                    append(s, i + k + 1, n - 1, builder);
                }
            }
            return builder.toString();
        }

        private void append(String s, int l, int r, StringBuilder builder) {
            for (; l <= r; l++) {
                builder.append(s.charAt(l));
            }
        }

        private void reverse(String s, int l, int r, StringBuilder builder) {
            for (int i = r; i >= l; i--) {
                builder.append(s.charAt(i));
            }
        }
    }

}
