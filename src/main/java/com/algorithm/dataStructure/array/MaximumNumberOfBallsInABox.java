package com.algorithm.dataStructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/
 *
 * @author songhuilong001  @date 2022/11/23
 */
public class MaximumNumberOfBallsInABox {

    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        Map<Integer, Integer> box2Cnt = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = getBox(i);
            int cnt = box2Cnt.getOrDefault(box, 0) + 1;
            box2Cnt.put(box, cnt);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public int getBox(int ballNum) {
        int sum = 0;
        while (ballNum > 0) {
            sum += ballNum % 10;
            ballNum /= 10;
        }
        return sum;
        // 用String stream 有空间开销
        // return String.valueOf(ballNum).chars().map(c-> c -'0').reduce(Integer::sum).orElse(-1);
    }

}
