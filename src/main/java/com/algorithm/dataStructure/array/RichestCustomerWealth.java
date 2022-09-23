package com.algorithm.dataStructure.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/richest-customer-wealth/
 *
 * @author songhuilong  @date 2022/9/23
 */
public class RichestCustomerWealth {

    static class ForLoopSum {
        public int maximumWealth(int[][] accounts) {
            int max = 0;
            for (int[] account : accounts) {
                int currBalance = 0;
                for (int deposit : account) {
                    currBalance += deposit;
                }
                max = Math.max(max, currBalance);
            }
            return max;
        }
    }

    static class SteamMapSum {
        public int maximumWealth(int[][] accounts) {
            // @formatter:off
            return Arrays.stream(accounts)
                    .map(account -> Arrays.stream(account).sum())
                    .max(Comparator.naturalOrder())
                    .orElse(-1);
            // @formatter:on
        }
    }

}
