package com.algorithm.dataStructure.array.slidingWindow;

/**
 * 3258. 统计满足 K 约束的子字符串数量 I
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
 * <p>
 * https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/description/
 *
 * @author songhuilong  @date 2024/11/12
 */
public class CountSubstringsThatSatisfyKConstraintI {

    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int[] cnt = new int[2];
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            int currCode = s.charAt(r) - '0';
            cnt[currCode]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l) - '0']--;
                l++;
            }
            // 当前 [l,r] 的段，以r结尾的任意子串都满足k约束
            // 子串可能性：r-l+1
            ans += r - l + 1;
        }
        return ans;
    }
}
