package com.algorithm.math;

/**
 * https://leetcode.cn/problems/bulb-switcher/
 *
 * @author songhuilong  @date 2022/9/15
 */
public class BulbSwitcher {

    public int bulbSwitch(int n) {
        // 初始灯泡都关闭
        boolean[] bulbs = new boolean[n];
        for (int i = 0; i < n; i++) {
            int step = i + 1;
            for (int j = 0; j < n; j += step) {
                if (step == 1) {
                    bulbs[j] = true;
                } else {
                    if (j + step - 1 < n) {
                        bulbs[j + step - 1] = !bulbs[j + step - 1];
                    }
                }
            }
        }
        int ans = 0;
        for (boolean bulb : bulbs) {
            if (bulb) {
                ans++;
            }
        }
        return ans;
    }

    public int bulbSwitch2(int n) {
        return (int) Math.sqrt(n);
    }
}
