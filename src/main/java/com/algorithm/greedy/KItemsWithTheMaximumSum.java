package com.algorithm.greedy;

/**
 * <a href="https://leetcode.cn/problems/k-items-with-the-maximum-sum/">2600. K 件物品的最大和</a>
 *
 * @author songhuilong  @date 2023/4/28
 */
public class KItemsWithTheMaximumSum {

    static class MathSolution {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            // 不需要加负数
            int positiveSum = Math.min(k, numOnes);
            if (k <= numOnes + numZeros) {
                return positiveSum;
            }
            // 需要加负数
            // 前置求出的和 - (k-numOnes-numZeros)*-1
            return positiveSum - (k - numOnes - numZeros);
        }
    }

    static class SimulationSolution {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            // sum表示所求最大和，i表示由正到负遍历下标
            int sum = 0, i = 0;
            int[] cntArr = new int[]{numOnes, numZeros, numNegOnes};
            while (k > 0) {
                int pickCnt = Math.min(k, cntArr[i]);
                k -= pickCnt;
                cntArr[i] -= pickCnt;
                sum += num(i) * pickCnt;
                if (cntArr[i] == 0) {
                    i++;
                }
            }
            return sum;
        }

        private int num(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 0;
            }
            return -1;
        }
    }

}
