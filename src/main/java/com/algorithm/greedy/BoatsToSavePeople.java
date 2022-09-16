package com.algorithm.greedy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/boats-to-save-people/
 *
 * @author songhuilong  @date 2022/9/16
 */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        // 贪心策略：体重升序，先把轻的人往船上装
        Arrays.sort(people);

        // 每次坐当前最重的，同时判断能不能捎上最轻的
        int ans = 0, n = people.length, light = 0, heavy = n - 1;
        while (light <= heavy) {
            // 最轻最重俩人可以坐一起
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            // 每个人体重一定小于等于limit
            ans++;
            heavy--;
        }
        return ans;
    }
}
