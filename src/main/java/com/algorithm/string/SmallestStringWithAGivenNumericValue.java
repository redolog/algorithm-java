package com.algorithm.string;

/**
 * https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/
 *
 * @author songhuilong001  @date 2023/1/26
 */
public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int sum) {
        char[] ans = new char[n];
        // 记录当前位填充后的和
        int currSum = 0;
        // [1,n]逐位判断填充哪个字符
        for (int i = 1; i <= n; i++) {
            char currC;
            if ((n - i) * 26 >= sum - currSum - 1) {
                // 剩下的位填充z，当前位填充a，和可以追平sum
                currC = 'a';
            } else {
                // 剩下的位填充z，当前位填充a，和追不平sum，多出的值需要当前位补偿
                if ((sum - currSum) % 26 == 0) {
                    // 能除尽，说明当前位填充z
                    currC = 'z';
                } else {
                    // 除不尽，说明当前位填充在z之前
                    currC = (char) (((sum - currSum) % 26) + 'a' - 1);
                }
            }
            ans[i - 1] = currC;
            currSum += currC - 'a' + 1;
        }
        return String.valueOf(ans);
    }
}
