package com.algorithm.dataStructure.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/assign-cookies/
 *
 * @author songhuilong  @date 2022/9/8
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;

        // i遍历胃口值g，j遍历饼干s
        for (int i = 0, j = 0; i < g.length; i++) {
            // 饼干还有，并且当前这个小孩还没喂饱
            while (j < s.length && g[i] > s[j]) {
                // 当前这个饼干不够小孩吃，下一个
                j++;
            }
            if (j < s.length && g[i] <= s[j]) {
                // 喂饱一个
                ans++;
                j++;
            }
        }

        return ans;
    }
}
