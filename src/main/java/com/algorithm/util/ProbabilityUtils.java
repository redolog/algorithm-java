package com.algorithm.util;

import com.algorithm.probability.EPFunction;

/**
 * 概率工具
 *
 * @author dragonsong  @date 2022/5/25
 */
public class ProbabilityUtils {

    private ProbabilityUtils() {
    }

    public static int[] runStoreEpCnts(int cnt, int start, int end, EPFunction function) {
        // randCounts 维护每个结果
        int[] randCounts = new int[end - start + 1];
        for (int i = 0; i < cnt; i++) {
            ++randCounts[function.ep01() - start];
        }
        return randCounts;
    }
}
