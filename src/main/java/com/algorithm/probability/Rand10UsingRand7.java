package com.algorithm.probability;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 * <p>
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * <p>
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [2,8]
 * 示例 3:
 * <p>
 * 输入: 3
 * 输出: [3,8,10]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 105
 * <p>
 * <p>
 * 进阶:
 * <p>
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 * <p>
 * https://leetcode.cn/problems/implement-rand10-using-rand7/
 *
 * @author dragonsong  @date 2022/7/18
 */
public class Rand10UsingRand7 {

    static class Binary {
        /**
         * 执行用时：
         * 17 ms
         * , 在所有 Java 提交中击败了
         * 13.32%
         * 的用户
         * 内存消耗：
         * 46.8 MB
         * , 在所有 Java 提交中击败了
         * 77.39%
         * 的用户
         * 通过测试用例：
         * 12 / 12
         */
        public int rand10() {
            int ans;
            do {
                ans = rand16();
            } while (ans < 1 || ans > 10);
            return ans;
        }

        public int rand16() {
            return (epBaseRand7() << 3) + (epBaseRand7() << 2) + (epBaseRand7() << 1) + epBaseRand7();
        }

        /**
         * 基于rand7实现一个0-1等概率函数
         */
        public int epBaseRand7() {
            int ans;
            do {
                ans = rand7();
            } while (ans == 4);
            return ans < 4 ? 0 : 1;
        }

        public int rand7() {
            return (int) (Math.random() * 7 + 1);
        }
    }

    /**
     * 七进制
     */
    static class Septenary {
        /**
         * 执行用时：
         * 18 ms
         * , 在所有 Java 提交中击败了
         * 10.50%
         * 的用户
         * 内存消耗：
         * 47.2 MB
         * , 在所有 Java 提交中击败了
         * 15.73%
         * 的用户
         * 通过测试用例：
         * 12 / 12
         */

        public int rand7() {
            return (int) (Math.random() * 7 + 1);
        }

        public int rand10() {
            int ans;
            do {
                ans = (rand7() - 1) * 7 + rand7() - 1;
            } while (ans < 1 || ans > 10);
            return ans;
        }
    }


}
