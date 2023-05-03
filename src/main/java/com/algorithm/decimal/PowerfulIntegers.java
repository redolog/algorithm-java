package com.algorithm.decimal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/powerful-integers/
 *
 * @author songhuilong001  @date 2023/5/3
 */
public class PowerfulIntegers {

    static class EnumerationSolution {
        /**
         * 枚举答案
         * 从x 0次方，一直枚举到 x的i次方小于等于bound
         * 从y 0次方，一直枚举到 y的j次方小于等于bound
         */
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> set = new HashSet<>();
            for (int i = (int) Math.pow(x, 0); i <= bound; i *= x) {
                for (int j = (int) Math.pow(y, 0); i + j <= bound; j *= y) {
                    set.add(i + j);
                    if (y == 1) {
                        break;
                    }
                }
                // 1是个特例，不管 1*x 多少次都是1，执行一次后要强制跳出
                if (x == 1) {
                    break;
                }
            }
            return new ArrayList<>(set);
        }
    }

    static class BFSolution {
        /**
         * 1 <= x, y <= 100
         * 0 <= bound <= 106
         */
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 2; i <= bound; i++) {
                if (isStrong(i, x, y)) {
                    ans.add(i);
                }
            }
            return ans;
        }

        /**
         * if xi + yj, then true else false
         * i >= 0 且 j >= 0
         */
        private boolean isStrong(int num, int x, int y) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (num == Math.pow(x, i) + Math.pow(y, j)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


}
