package com.algorithm.dataStructure.array.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/
 *
 * @author songhuilong001  @date 2023/5/15
 */
public class FlipColumnsForMaximumNumberOfEqualRows {

    /**
     * 本题给定一个矩阵，其中的元素为 0、1。
     * 根据题目所求：Return the maximum number of rows that have all values equal after some number of flips.
     * 1. 每个列可以翻转；
     * 2. 翻转后0变成1，1变成0；
     * 3. 001 等同于 110，我们统一统计0开头的，1开头的将本行转换为0开头；
     * 4. 统计每行的key对应cnt，求最大cnt；
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        return Arrays.stream(matrix)
                .map(row -> {
                    int start = row[0];
                    StringBuilder builder = new StringBuilder();
                    for (int c : row) {
                        if (start == 1) {
                            builder.append(c == 0 ? 1 : 0);
                        } else {
                            builder.append(c);
                        }
                        builder.append("_");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    return builder.toString();
                })
                .collect(Collectors.toMap(key -> key, key -> 1, Integer::sum))
                .values()
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(-1);
    }
}
