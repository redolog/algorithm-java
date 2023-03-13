package com.algorithm.greedy;

/**
 * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
 *
 * @author songhuilong  @date 2023/3/13
 */
public class MinimumHoursOfTrainingToWinACompetition {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int enSum = 0;
        for (int e : energy) {
            enSum += e;
        }
        int ans = 0;
        if (initialEnergy <= enSum) {
            // 当前能量少于等于最后需要的总能量时，叠加差值
            ans = enSum + 1 - initialEnergy;
        }
        int n = energy.length, exSum = initialExperience;
        for (int i = 0; i < n; i++) {
            int exCurr = experience[i];
            if (exSum <= exCurr) {
                // 当前经验值少于等于当前对手的经验值时，训练差值
                int gap = exCurr + 1 - exSum;
                ans += gap;
                exCurr += gap;
            }
            exSum += exCurr;
        }
        return ans;
    }
}
